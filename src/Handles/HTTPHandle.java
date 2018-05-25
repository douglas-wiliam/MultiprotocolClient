package Handles;

import Base.HTTPClient;
import Utilities.OutputStreamCustomizado;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author douglas, diego
 */
public class HTTPHandle extends javax.swing.JFrame {

    HTTPClient browser;
    String url;

    PrintStream printStream;

    public HTTPHandle() {
        initComponents();
        // Desviando msgs do terminal para JTextArea
        printStream = new PrintStream(new OutputStreamCustomizado(CaixaTextoSite));
        System.setOut(printStream);
        System.setErr(printStream);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialogo_CampoVazio = new javax.swing.JDialog();
        Painel_CamposVazios = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        BotaoOK_Dialogo = new javax.swing.JButton();
        PainelBase = new javax.swing.JPanel();
        CampoTextoURL = new javax.swing.JTextField();
        BotaoIr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CaixaTextoSite = new javax.swing.JTextArea();

        Dialogo_CampoVazio.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Dialogo_CampoVazio.setTitle("Alerta!");
        Dialogo_CampoVazio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Dialogo_CampoVazio.setMinimumSize(new java.awt.Dimension(220, 110));
        Dialogo_CampoVazio.setResizable(false);
        Dialogo_CampoVazio.getContentPane().setLayout(null);

        Painel_CamposVazios.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Campos Vazios!");
        Painel_CamposVazios.add(jLabel5);
        jLabel5.setBounds(20, 0, 160, 20);

        BotaoOK_Dialogo.setText("OK");
        BotaoOK_Dialogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoOK_DialogoActionPerformed(evt);
            }
        });
        Painel_CamposVazios.add(BotaoOK_Dialogo);
        BotaoOK_Dialogo.setBounds(60, 30, 80, 30);

        Dialogo_CampoVazio.getContentPane().add(Painel_CamposVazios);
        Painel_CamposVazios.setBounds(10, 10, 220, 110);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HTTP Tiny Browser");
        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(null);

        PainelBase.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelBase.setMaximumSize(new java.awt.Dimension(640, 480));
        PainelBase.setMinimumSize(new java.awt.Dimension(640, 480));
        PainelBase.setPreferredSize(new java.awt.Dimension(640, 480));
        PainelBase.setLayout(null);
        PainelBase.add(CampoTextoURL);
        CampoTextoURL.setBounds(20, 80, 530, 20);

        BotaoIr.setText("Ir");
        BotaoIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoIrActionPerformed(evt);
            }
        });
        PainelBase.add(BotaoIr);
        BotaoIr.setBounds(550, 70, 50, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setText("BROWSER");
        PainelBase.add(jLabel2);
        jLabel2.setBounds(200, 20, 210, 43);

        CaixaTextoSite.setEditable(false);
        CaixaTextoSite.setColumns(20);
        CaixaTextoSite.setRows(5);
        jScrollPane1.setViewportView(CaixaTextoSite);

        PainelBase.add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 580, 280);

        getContentPane().add(PainelBase);
        PainelBase.setBounds(10, 10, 620, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoIrActionPerformed
        url = CampoTextoURL.getText();

        if (!"".equals(url)) {
            browser = new HTTPClient(url);
            try {
                CaixaTextoSite.setText("Carregando...\n");
                browser.conecta();
                browser.get();
                browser.print();
            } catch (Exception ex) {
                Logger.getLogger(HTTPHandle.class.getName()).log(Level.SEVERE, null, ex);
                CaixaTextoSite.setText("Falha ao carregar site");
            }
        } else {
            Dialogo_CampoVazio.setVisible(true);
        }
    }//GEN-LAST:event_BotaoIrActionPerformed

    private void BotaoOK_DialogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoOK_DialogoActionPerformed
        Dialogo_CampoVazio.dispose();
    }//GEN-LAST:event_BotaoOK_DialogoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoIr;
    private javax.swing.JButton BotaoOK_Dialogo;
    private javax.swing.JTextArea CaixaTextoSite;
    private javax.swing.JTextField CampoTextoURL;
    private javax.swing.JDialog Dialogo_CampoVazio;
    private javax.swing.JPanel PainelBase;
    private javax.swing.JPanel Painel_CamposVazios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
