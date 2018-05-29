package Base;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author douglas, diego
 */
public class SMTPClient {

    Socket socket;
    private static DataOutputStream dos;
    private BufferedReader br;
    private final int porta;
    private final int delay;
    private final String server;
    private final String usuario;
    private final String senha;
    private final String authUsuario;
    private final String authSenha;
    private final String destinatario;

    private final InetAddress serverHost;
    private final InetAddress localHost;

    public SMTPClient(String server, int porta, String usuario, String senha, String destinatario) throws UnknownHostException {
        this.server = server;
        this.porta = porta;
        delay = 1000;
        this.usuario = usuario;
        this.senha = senha;
        this.destinatario = destinatario;

        localHost = InetAddress.getLocalHost();
        serverHost = InetAddress.getByName(server);

        authUsuario = Base64.getEncoder().encodeToString(usuario.getBytes(StandardCharsets.UTF_8));
        authSenha = Base64.getEncoder().encodeToString(senha.getBytes(StandardCharsets.UTF_8));

    }

    public void conecta() throws IOException, InterruptedException {

        socket = new Socket(serverHost, porta);

        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        (new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        System.out.println("SERVER: " + linha);
                    }
                } catch (IOException ex) {

                    ex.printStackTrace();
                }

            }
        })).start();

        dos = new DataOutputStream(socket.getOutputStream());

        envia("EHLO " + localHost + "\r\n");
        Thread.sleep(delay);
        envia("AUTH LOGIN\r\n");
        Thread.sleep(delay);
        envia(authUsuario + "\r\n");
        Thread.sleep(delay);
        envia(authSenha + "\r\n");
        Thread.sleep(delay);
        envia("MAIL FROM:<" + usuario + ">\r\n");
        Thread.sleep(delay);
        envia("RCPT TO:<" + destinatario + ">\r\n");
        Thread.sleep(delay);
        envia("DATA\r\n");
        Thread.sleep(delay);
        envia("From: " + usuario + "\r\n");
        Thread.sleep(delay);
        envia("To: " + destinatario + "\r\n");
        Thread.sleep(delay);
        envia("Subject: Teste de Envio de Email -  Cliente SMTP\r\n");
        Thread.sleep(delay);
        envia("Diego Raian e Douglas Wiliam\r\n");
        Thread.sleep(delay);
        envia(".\r\n");
        Thread.sleep(delay);
        envia("QUIT\r\n");
    }

    private static void envia(String comando) throws IOException {
        dos.writeBytes(comando);
        System.out.println("CLIENTE: " + comando);
    }

}
