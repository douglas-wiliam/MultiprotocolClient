package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author douglas, diego
 */
public class HTTPClient {

    private String url;
    private URI uri;
    private String host;
    private String path;
    private String query;
    private String protocolo;
    private int porta;
    private Socket socket;
    PrintWriter request;
    private String encodedAuth;
    InputStream response;

    public HTTPClient(String url) { //"https://www.mkyong.com"
        this.url = url;
        try {
            uri = new URI(url);
        } catch (URISyntaxException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        host = uri.getHost();
        path = uri.getRawPath();
        query = uri.getRawQuery();
        protocolo = uri.getScheme();
        porta = uri.getPort();
    }

    public void conecta() {

        if (path == null || path.length() == 0) {
            path = "/";
        }

        if (query != null && query.length() > 0) {
            path += "?" + query;
        }

        if (porta == -1) {
            if (protocolo.equals("http")) {
                porta = 80;
            } else if (protocolo.equals("https")) {
                porta = 443;
            } else {
                System.out.println("Protocolo de Transferencia Invalido!");
            }
        }

        try {   // Tentando conectar
            socket = new Socket(host, porta);
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problema conexao Host/Porta");
        }

        System.out.println("Saiu conecta.");
    }

    public void get() {
        encodedAuth = "";

        try {
            request = new PrintWriter(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problema ao enviar request.");
        }

        request.print("GET " + path + " HTTP/1.1\r\n"
                + "Host: " + host + "\r\n"
                + "Authorization: Basic " + encodedAuth + "\r\n"
                + "Connection: close\r\n\r\n");
        request.flush();
        System.out.println("Saiu get.");
    }

    public void print() {
        BufferedReader br;
        String linha;

        try {
            System.out.println("Recebendo dados.");
            response = socket.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problema ao receber response.");
        }

        br = new BufferedReader(new InputStreamReader(response));

        try {
            System.out.println("Imprimindo dados.");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException ex) {
            Logger.getLogger(HTTPClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problema ao ler response.");
        }
        System.out.println("Saiu print");
    }
}
