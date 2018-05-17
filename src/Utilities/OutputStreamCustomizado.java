package Utilities;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author douglas
 */
public class OutputStreamCustomizado extends OutputStream {

    private JTextArea textArea;

    public OutputStreamCustomizado(JTextArea textArea){
        this.textArea = textArea;
    }
    
    @Override
    public void write(int i) throws IOException {
        textArea.append(String.valueOf(i));
        textArea.setCaretPosition(textArea.getDocument().getLength());
        textArea.update(textArea.getGraphics());
    }
    
}
