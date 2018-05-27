package Base;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class FTPClient {

	private Socket socket = null;

	private BufferedReader reader = null;

	private BufferedWriter writer = null;



	public synchronized void conectar(String host, int port, String user, String pass) throws IOException {
		if (socket != null) {
			throw new IOException("SimpleFTP is already connected. Disconnect first.");
		}
	
		socket = new Socket(host, port);
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		String response = readLine();
		if (!response.startsWith("220 ")) {
			throw new IOException(
					"SimpleFTP received an unknown response when connecting to the FTP server: " + response);
		}

		sendLine("USER " + user);

		response = readLine();
		if (!response.startsWith("331 ")) {
			throw new IOException("SimpleFTP received an unknown response after sending the user: " + response);
		}

		sendLine("PASS " + pass);

		response = readLine();
		if (!response.startsWith("230 ")) {
			throw new IOException("SimpleFTP was unable to log in with the supplied password: " + response);
		}

	}

	/**
	 * Disconecta do servidor FTP
	 */
	public synchronized void desconectar() throws IOException {
		try {
			sendLine("QUIT");
		} finally {
			socket = null;
		}
	}

	/**
	 * Diretório corrente 
	 */
	public synchronized String pwd() throws IOException {
		sendLine("PWD");
		String dir = null;
		String response = readLine();
		if (response.startsWith("257 ")) {
			int firstQuote = response.indexOf('\"');
			int secondQuote = response.indexOf('\"', firstQuote + 1);
			if (secondQuote > 0) {
				dir = response.substring(firstQuote + 1, secondQuote);
			}
		}
		return dir;
	}

	/**
	 * Muda o diretório
	 */
	public synchronized boolean mudarDiretorio(String dir) throws IOException {
		sendLine("CWD " + dir);
		String response = readLine();
		return (response.startsWith("250 "));
	}


	/**
	 * Envia o arquivo para o diretório do ftp
	 */
	public synchronized boolean enviarArquivo(File arquivo) throws IOException {

		if(arquivo.isDirectory()){
			throw new IOException("Esse caminho trata-se de um diretório");
		}
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(arquivo));

		DadosConexao dados = entrarModoPassivo();

		sendLine("STOR " + arquivo.getName());
	
		Socket dataSocket = new Socket(dados.getIp(), dados.getPorta());

		String response = readLine();
		if (response.startsWith("125 ")) {
			throw new IOException("Não foi possível enviar o arquivo "+ arquivo.getName());
		}

		BufferedOutputStream output = new BufferedOutputStream(dataSocket.getOutputStream());
		byte[] buffer = new byte[4096];
		int bytesRead = 0;
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}
		output.flush();
		output.close();
		input.close();

		response = readLine();
		return response.startsWith("226 ");
	}

	
	public synchronized DadosConexao entrarModoPassivo() throws IOException{
		sendLine("PASV");
        String response =  readLine();
		String ip = null;
		Integer porta = -1;
		int opening = response.indexOf('(');
		int closing = response.indexOf(')', opening + 1);
		if (closing > 0) {
			String dataLink = response.substring(opening + 1, closing);
			StringTokenizer tokenizer = new StringTokenizer(dataLink, ",");
			try {
				ip = tokenizer.nextToken() + "." + tokenizer.nextToken() + "." + tokenizer.nextToken() + "."
						+ tokenizer.nextToken();
				porta = Integer.parseInt(tokenizer.nextToken()) * 256 + Integer.parseInt(tokenizer.nextToken());
				return new DadosConexao(ip, porta);
			} catch (Exception e) {
				throw new IOException("Dados de conexão incorretos, não foi possível entrar em modo pass");
			}
		}
		return null;
	}
	/**
	 * lista os arquivos do diretório
	 */
	public synchronized void listarArquivos() throws IOException {

        DadosConexao dados = entrarModoPassivo();
        Socket dataConnection = new Socket();
        try {
            dataConnection = new Socket(dados.getIp(), dados.getPorta());
            
            sendLine("LIST");
            
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(dataConnection.getInputStream()));
           String line = null;
            while((line = dataIn.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException io) {
            System.out.println("835 Data transfer connection I/O error, closing data connection.");
            dataConnection.close();
        } catch (IllegalArgumentException i) {
            System.out.println("830 Data transfer connection to " + dados.getIp() + " on port " + dados.getPorta() + " failed to open.");
        }
	}

	/**
	 * Enter ASCII mode for sending text files. This is usually the default
	 * mode. Make sure you use binary mode if you are sending images or other
	 * binary data, as ASCII mode is likely to corrupt them.
	 */
	public synchronized boolean ascii() throws IOException {
		sendLine("TYPE A");
		String response = readLine();
		return (response.startsWith("200 "));
	}

	/**
	 * Sends a raw command to the FTP server.
	 */
	private void sendLine(String line) throws IOException {
		if (socket == null) {
			throw new IOException("SimpleFTP is not connected.");
		}
		try {
			writer.write(line + "\r\n");
			writer.flush();
		} catch (IOException e) {
			socket = null;
			throw e;
		}
	}

	private String readLine() throws IOException {
		return reader.readLine();
	}

}
