package Handles;

import Base.SMTP_SSLClient;
import java.awt.CardLayout;

/**
 *
 * @author douglas
 */
public class SMTPHandle extends javax.swing.JFrame {

    SMTP_SSLClient mail;
    String usuario, senha, server, porta, destinatario, assunto, mensagem;

    public SMTPHandle() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CampoTextoUsuario = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        Copyright = new javax.swing.JLabel();
        CampoTextoSenha = new javax.swing.JPasswordField();
        BotaoLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CampoTextoServer = new javax.swing.JTextField();
        CampoTextoPorta = new javax.swing.JTextField();
        PainelEnviarEmail = new javax.swing.JPanel();
        TituloEMAIL = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CampoTextoDestinatario = new javax.swing.JTextField();
        CampoTextoAssunto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CaixaTextoMensagem = new javax.swing.JTextArea();
        BotaoEnviar = new javax.swing.JButton();
        Copyright1 = new javax.swing.JLabel();

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

        jLabel1.setText("Usuário:");
        PainelLogin.add(jLabel1);
        jLabel1.setBounds(130, 230, 60, 20);

        jLabel2.setText("Senha:");
        PainelLogin.add(jLabel2);
        jLabel2.setBounds(130, 290, 60, 15);

        CampoTextoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoTextoUsuarioActionPerformed(evt);
            }
        });
        PainelLogin.add(CampoTextoUsuario);
        CampoTextoUsuario.setBounds(250, 230, 200, 30);

        Titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Titulo.setText("LOGIN");
        PainelLogin.add(Titulo);
        Titulo.setBounds(240, 30, 130, 80);

        Copyright.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        Copyright.setText("Copyright © 2018 Douglas Wiliam <dougl.wil@gmail.com>, Diego Raian <diego.raian@gmail.com>, all rights reserved");
        PainelLogin.add(Copyright);
        Copyright.setBounds(20, 420, 600, 20);

        CampoTextoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoTextoSenhaActionPerformed(evt);
            }
        });
        PainelLogin.add(CampoTextoSenha);
        CampoTextoSenha.setBounds(250, 280, 200, 30);

        BotaoLogin.setText("Avançar");
        BotaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLoginActionPerformed(evt);
            }
        });
        PainelLogin.add(BotaoLogin);
        BotaoLogin.setBounds(356, 340, 90, 25);

        jLabel3.setText("Server(SMTP):");
        PainelLogin.add(jLabel3);
        jLabel3.setBounds(130, 130, 100, 20);

        jLabel4.setText("Porta:");
        PainelLogin.add(jLabel4);
        jLabel4.setBounds(130, 190, 42, 15);
        PainelLogin.add(CampoTextoServer);
        CampoTextoServer.setBounds(250, 130, 200, 30);
        PainelLogin.add(CampoTextoPorta);
        CampoTextoPorta.setBounds(250, 180, 200, 30);

        PainelBase.add(PainelLogin, "card2");

        PainelEnviarEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelEnviarEmail.setMaximumSize(new java.awt.Dimension(616, 456));
        PainelEnviarEmail.setMinimumSize(new java.awt.Dimension(616, 456));
        PainelEnviarEmail.setPreferredSize(new java.awt.Dimension(640, 456));
        PainelEnviarEmail.setLayout(null);

        TituloEMAIL.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        TituloEMAIL.setText("EMAIL");
        PainelEnviarEmail.add(TituloEMAIL);
        TituloEMAIL.setBounds(270, 10, 130, 80);

        jLabel6.setText("Assunto:");
        PainelEnviarEmail.add(jLabel6);
        jLabel6.setBounds(70, 180, 60, 15);

        jLabel7.setText("Destinatário:");
        PainelEnviarEmail.add(jLabel7);
        jLabel7.setBounds(70, 110, 90, 15);

        jLabel8.setText("Mensagem:");
        PainelEnviarEmail.add(jLabel8);
        jLabel8.setBounds(70, 270, 80, 15);
        PainelEnviarEmail.add(CampoTextoDestinatario);
        CampoTextoDestinatario.setBounds(190, 100, 270, 30);

        CampoTextoAssunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoTextoAssuntoActionPerformed(evt);
            }
        });
        PainelEnviarEmail.add(CampoTextoAssunto);
        CampoTextoAssunto.setBounds(190, 170, 350, 30);

        CaixaTextoMensagem.setColumns(20);
        CaixaTextoMensagem.setRows(5);
        jScrollPane1.setViewportView(CaixaTextoMensagem);

        PainelEnviarEmail.add(jScrollPane1);
        jScrollPane1.setBounds(190, 240, 350, 100);

        BotaoEnviar.setText("Enviar");
        BotaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviarActionPerformed(evt);
            }
        });
        PainelEnviarEmail.add(BotaoEnviar);
        BotaoEnviar.setBounds(480, 350, 77, 25);

        Copyright1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        Copyright1.setText("Copyright © 2018 Douglas Wiliam <dougl.wil@gmail.com>, Diego Raian <diego.raian@gmail.com>, all rights reserved");
        PainelEnviarEmail.add(Copyright1);
        Copyright1.setBounds(20, 420, 600, 20);

        PainelBase.add(PainelEnviarEmail, "card2");
        PainelEnviarEmail.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(PainelBase, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoTextoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTextoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTextoSenhaActionPerformed

    private void CampoTextoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTextoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTextoUsuarioActionPerformed

    private void BotaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLoginActionPerformed
        CardLayout cl;

        usuario = CampoTextoUsuario.getText();
        server = CampoTextoServer.getText();
        porta = CampoTextoPorta.getText();
        senha = String.copyValueOf(CampoTextoSenha.getPassword());

        if ((!"".equals(usuario)) && (!"".equals(server)) && (!"".equals(porta)) && (!"".equals(senha))) {
            mail = new SMTP_SSLClient(server, porta);
            mail.login(usuario, senha);
            cl = (CardLayout) PainelBase.getLayout();
            cl.addLayoutComponent(PainelLogin, "PainelLogin");
            cl.addLayoutComponent(PainelEnviarEmail, "PainelEnviarEmail");
            cl.show(PainelBase, "PainelEnviarEmail");
        } else {
            Dialogo_CampoVazioLogin.setVisible(true);
        }
    }//GEN-LAST:event_BotaoLoginActionPerformed

    private void CampoTextoAssuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTextoAssuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTextoAssuntoActionPerformed

    private void BotaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviarActionPerformed
        destinatario = CampoTextoDestinatario.getText();
        assunto = CampoTextoAssunto.getText();
        mensagem = CaixaTextoMensagem.getText();

        if ((!"".equals(destinatario)) && (!"".equals(assunto)) && (!"".equals(mensagem))) {

            mail.envia(usuario, destinatario, assunto, mensagem);
        } else {
            Dialogo_CampoVazioLogin.setVisible(true);
        }
    }//GEN-LAST:event_BotaoEnviarActionPerformed

    private void BotaoOK_DialogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoOK_DialogoActionPerformed
        Dialogo_CampoVazioLogin.dispose();
    }//GEN-LAST:event_BotaoOK_DialogoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEnviar;
    private javax.swing.JButton BotaoLogin;
    private javax.swing.JButton BotaoOK_Dialogo;
    private javax.swing.JTextArea CaixaTextoMensagem;
    private javax.swing.JTextField CampoTextoAssunto;
    private javax.swing.JTextField CampoTextoDestinatario;
    private javax.swing.JTextField CampoTextoPorta;
    private javax.swing.JPasswordField CampoTextoSenha;
    private javax.swing.JTextField CampoTextoServer;
    private javax.swing.JTextField CampoTextoUsuario;
    private javax.swing.JLabel Copyright;
    private javax.swing.JLabel Copyright1;
    private javax.swing.JDialog Dialogo_CampoVazioLogin;
    private javax.swing.JPanel PainelBase;
    private javax.swing.JPanel PainelEnviarEmail;
    private javax.swing.JPanel PainelLogin;
    private javax.swing.JPanel Painel_CamposVazios;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel TituloEMAIL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
