package Base;

import Handles.FTPHandler;
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
            	FTPHandler ftp  = new FTPHandler();
            	ftp.setVisible(true);
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
