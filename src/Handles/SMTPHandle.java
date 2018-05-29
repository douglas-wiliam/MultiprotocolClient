package Handles;

import Base.SMTPClient;
import Utilities.OutputStreamCustomizado;
import java.io.IOException;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author douglas, diego
 */
public class SMTPHandle extends javax.swing.JFrame {

    SMTPClient mail;
    String usuario, senha, emailDestino, server;
    int porta;

    PrintStream printStream;

    public SMTPHandle() {
        initComponents();
        // Desviando msgs do terminal para JTextArea
        printStream = new PrintStream(new OutputStreamCustomizado(CaixaTextoRespostaServer));
        System.setOut(printStream);
        System.setErr(printStream);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialogo_CampoVazioLogin = new javax.swing.JDialog();
        Painel_CamposVazios = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        BotaoOK_Dialogo = new javax.swing.JButton();
        PainelBase = new javax.swing.JPanel();
        PainelLogin = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        BotaoLimpar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CampoTextoPorta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CaixaTextoRespostaServer = new javax.swing.JTextArea();
        CampoTextoServer = new javax.swing.JTextField();
        CampoEmailDestino = new javax.swing.JTextField();
        BotaoConectar = new javax.swing.JButton();
        CampoTextoUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CampoSenha = new javax.swing.JPasswordField();

        Dialogo_CampoVazioLogin.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Dialogo_CampoVazioLogin.setTitle("Alerta!");
        Dialogo_CampoVazioLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Dialogo_CampoVazioLogin.setMinimumSize(new java.awt.Dimension(246, 135));
        Dialogo_CampoVazioLogin.setResizable(false);
        Dialogo_CampoVazioLogin.getContentPane().setLayout(null);

        Painel_CamposVazios.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Campos Vazios!");
        Painel_CamposVazios.add(jLabel5);
        jLabel5.setBounds(30, 10, 160, 20);

        BotaoOK_Dialogo.setText("OK");
        BotaoOK_Dialogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoOK_DialogoActionPerformed(evt);
            }
        });
        Painel_CamposVazios.add(BotaoOK_Dialogo);
        BotaoOK_Dialogo.setBounds(60, 50, 80, 30);

        Dialogo_CampoVazioLogin.getContentPane().add(Painel_CamposVazios);
        Painel_CamposVazios.setBounds(10, 10, 220, 110);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Envia Mail");
        setMinimumSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        PainelBase.setLayout(new java.awt.CardLayout(1, 1));

        PainelLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelLogin.setMaximumSize(new java.awt.Dimension(616, 456));
        PainelLogin.setMinimumSize(new java.awt.Dimension(616, 456));
        PainelLogin.setLayout(null);

        Titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Titulo.setText("SMTP");
        PainelLogin.add(Titulo);
        Titulo.setBounds(270, 10, 120, 80);

        BotaoLimpar.setText("Limpar");
        BotaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLimparActionPerformed(evt);
            }
        });
        PainelLogin.add(BotaoLimpar);
        BotaoLimpar.setBounds(370, 390, 100, 25);

        jLabel3.setText("Email Destino:");
        PainelLogin.add(jLabel3);
        jLabel3.setBounds(20, 180, 100, 30);

        jLabel4.setText("Porta:");
        PainelLogin.add(jLabel4);
        jLabel4.setBounds(20, 140, 42, 30);
        PainelLogin.add(CampoTextoPorta);
        CampoTextoPorta.setBounds(140, 140, 200, 30);

        jLabel9.setText("Server(SMTP):");
        PainelLogin.add(jLabel9);
        jLabel9.setBounds(20, 100, 100, 30);

        jLabel10.setText("Senha:");
        PainelLogin.add(jLabel10);
        jLabel10.setBounds(360, 180, 60, 30);

        CaixaTextoRespostaServer.setEditable(false);
        CaixaTextoRespostaServer.setColumns(20);
        CaixaTextoRespostaServer.setRows(5);
        jScrollPane2.setViewportView(CaixaTextoRespostaServer);

        PainelLogin.add(jScrollPane2);
        jScrollPane2.setBounds(80, 230, 500, 140);
        PainelLogin.add(CampoTextoServer);
        CampoTextoServer.setBounds(140, 100, 200, 30);
        PainelLogin.add(CampoEmailDestino);
        CampoEmailDestino.setBounds(140, 180, 200, 30);

        BotaoConectar.setText("Conectar");
        BotaoConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConectarActionPerformed(evt);
            }
        });
        PainelLogin.add(BotaoConectar);
        BotaoConectar.setBounds(180, 390, 100, 25);
        PainelLogin.add(CampoTextoUsuario);
        CampoTextoUsuario.setBounds(420, 100, 200, 30);

        jLabel11.setText("Usuário:");
        PainelLogin.add(jLabel11);
        jLabel11.setBounds(360, 100, 60, 30);
        PainelLogin.add(CampoSenha);
        CampoSenha.setBounds(420, 180, 200, 30);

        PainelBase.add(PainelLogin, "card2");

        getContentPane().add(PainelBase, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLimparActionPerformed
        CaixaTextoRespostaServer.setText("");
    }//GEN-LAST:event_BotaoLimparActionPerformed

    private void BotaoOK_DialogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoOK_DialogoActionPerformed
        Dialogo_CampoVazioLogin.dispose();
    }//GEN-LAST:event_BotaoOK_DialogoActionPerformed

    private void BotaoConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConectarActionPerformed

        emailDestino = CampoEmailDestino.getText();
        usuario = CampoTextoUsuario.getText();
        senha = String.valueOf(CampoSenha.getPassword());
        server = CampoTextoServer.getText();
        porta = Integer.parseInt(CampoTextoPorta.getText());

        if ((!"".equals(usuario)) && (!"".equals(server)) && (!"".equals(porta)) && (!"".equals(emailDestino)) && (!"".equals(senha))) {
            try {
                mail = new SMTPClient(server, porta, usuario, senha, emailDestino);
            } catch (UnknownHostException ex) {
                Logger.getLogger(SMTPHandle.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                mail.conecta();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(SMTPHandle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Dialogo_CampoVazioLogin.setVisible(true);
        }
    }//GEN-LAST:event_BotaoConectarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoConectar;
    private javax.swing.JButton BotaoLimpar;
    private javax.swing.JButton BotaoOK_Dialogo;
    private javax.swing.JTextArea CaixaTextoRespostaServer;
    private javax.swing.JTextField CampoEmailDestino;
    private javax.swing.JPasswordField CampoSenha;
    private javax.swing.JTextField CampoTextoPorta;
    private javax.swing.JTextField CampoTextoServer;
    private javax.swing.JTextField CampoTextoUsuario;
    private javax.swing.JDialog Dialogo_CampoVazioLogin;
    private javax.swing.JPanel PainelBase;
    private javax.swing.JPanel PainelLogin;
    private javax.swing.JPanel Painel_CamposVazios;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
