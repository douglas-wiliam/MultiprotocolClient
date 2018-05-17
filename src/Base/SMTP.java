package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author douglas
 */
public class SMTP {

    private final int porta;

    private final InetAddress mailHost;
    private final InetAddress localHost;

    BufferedReader in;
    PrintWriter out;

    public SMTP(String server, int porta) throws UnknownHostException {
        this.porta = porta;
        mailHost = InetAddress.getByName(server);
        localHost = InetAddress.getLocalHost();

        System.out.println("mailhost = " + mailHost);
        System.out.println("localHost= " + localHost);
        System.out.println("Construtor SMTP terminado.\n");
    }

    public boolean send(String msg, String remet, String dest) throws IOException {
        Socket smtpPipe;
        InputStream inn;
        OutputStream outt;

        smtpPipe = new Socket(mailHost, porta);

        if (smtpPipe == null) {
            return false;
        }

        inn = smtpPipe.getInputStream();
        outt = smtpPipe.getOutputStream();

        in = new BufferedReader(new InputStreamReader(inn));
        out = new PrintWriter(new OutputStreamWriter(outt), true);

        if (inn == null || outt == null) {
            System.out.println("Falha ao ler socket");
            return false;
        }

        String initialID = in.readLine();
        System.out.println(initialID);

        System.out.println("HELO " + localHost.getHostName());
        out.println("HELO " + localHost.getHostName());
        
        System.out.println("\n Aguardando resposta...");
        
        String welcome = in.readLine();
        System.out.println(welcome);

        System.out.println("MAIL From:<" + remet + ">");
        out.println("MAIL From:<" + remet + ">");

        String enviadoOK = in.readLine();
        System.out.println(enviadoOK);

        System.out.println("RCPT TO:<" + dest + ">");
        out.println("RCPT TO:<" + dest + ">");

        String recebidoOK = in.readLine();
        System.out.println(recebidoOK);

        System.out.println("DATA");
        out.println("DATA");

        out.println(msg);

        System.out.println(".");
        out.println(".");

        String aceitoOK = in.readLine();
        System.out.println(aceitoOK);

        System.out.println("QUIT");
        out.println("QUIT");

        return true;
    }
}
