package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

/**
 *
 * @author douglas, diego
 */
public class SMTPClient {

    private final String msg;
    private final String remet;
    private final String dest;
    private final String server;
    private final int porta;
    
    private SMTP mail;

    private BufferedReader in;
    private PrintWriter out;

    public SMTPClient(String msg, String remet, String dest, String server, int porta) throws UnknownHostException, IOException {
        this.msg = msg;
        this.remet = remet;
        this.dest = dest;
        this.server = server;
        this.porta = porta;

        mail = new SMTP(server, porta);

        if (mail != null) {
            if (mail.send(this.msg, this.remet, this.dest)) {
                System.out.println("E-mail enviado.");
            } else {
                System.out.println("Conexão com o servidor SMTP falhou!");
            }
        }

        System.out.println("Terminado.");
    }
}
