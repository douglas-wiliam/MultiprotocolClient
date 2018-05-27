package Base;

import Handles.HTTPHandle;
import Handles.SMTPHandle;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author douglas, diego
 */
public class Terminal {

    public static void main(String[] args) throws Exception {
        String input;
        Scanner getInput = new Scanner(System.in); 

        System.out.println("Digite qual aplicação vai usar baseado no protocolo(ftp, http, smtp): ");
        input = getInput.next();
        switch (input) {

            case ("ftp"):
            	FTPClient ftp = new  FTPClient();
            	ftp.conectar("192.168.1.16", 21, "admin", "admin");
            	ftp.stor(new File("/home/diegoraian/Documentos/eXtreme programming  Praticas para o dia-a-dia no desenvolvimento agil de software - Casa do Codigo"));
            	ftp.showFiles();
            	ftp.disconnect();
            	
//            	FTPClient ftp = new  FTPClient();
//            	ftp.conectar("192.168.1.16", 21, "admin", "admin");
//            	ftp.showFiles();
//            	ftp.stor(new File("/home/diegoraian/Documentos/eXtreme programming  Praticas para o dia-a-dia no desenvolvimento agil de software - Casa do Codigo"));
//            	ftp.disconnect();
//            	SimpleFTP ftp = new SimpleFTP();
//            	ftp.connect("localhost", 21, "admin", "admin");
//            	ftp.stor(new File("/home/diegoraian/Documentos/ftp/Main.java"));
//            	ftp.disconnect();
                break;

            case ("http"):
                HTTPHandle http = new HTTPHandle();
                http.setVisible(true);
                break;

            case ("smtp"):
                SMTPHandle smtp = new SMTPHandle();
                smtp.setVisible(true);
                break;

            default:
                System.out.println("Opção Inválida.");
                break;

        }

    }
    
    
    

}
