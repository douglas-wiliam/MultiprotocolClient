package Base;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author douglas
 */
public class SMTP_SSLClient {

    Properties props = new Properties();
    Session sessao;

    public SMTP_SSLClient(String SMTPServer, String porta) {
        props.put("mail.smtp.host", SMTPServer);
        props.put("mail.smtp.socketFactory.port", porta);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", porta);
    }

    public void login(String usuario, String senha) {

        sessao = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, senha);
            }
        }
        );

    }

    public void envia(String emailRemetente, String emailDestinatario, String assunto, String texto) {

        try {
            Message mensagem = new MimeMessage(sessao);
            mensagem.setFrom(new InternetAddress(emailRemetente));
            mensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestinatario));

            mensagem.setSubject(assunto);
            mensagem.setText(texto);

            System.out.println("Enviando...");

            Transport.send(mensagem);

            System.out.println("E-mail Enviado.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
