package Handles;

import Base.FTPClient;
import Utilities.OutputStreamCustomizado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author douglas, diego
 */
public class FTPHandler extends javax.swing.JFrame {

	FTPClient ftpClient ;
    String url;

    PrintStream printStream;
	private JTextField CampoTextoPort;
	private JTextField CampoTextoPassword;
	private JTextField CampoTextoUser;
	private JLabel jLabelUsername;
	private JLabel jLabelHost;
    private JButton BotaoConectar;
    private JButton BotaoOK_Dialogo;
    private JButton BotaoEnviar;
    private JTextArea CaixaTextoSite;
    private JTextField CampoTextoHost;
    private JDialog Dialogo_CampoVazio;
    private JPanel PainelBase;
    private JPanel Painel_CamposVazios;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JScrollPane jScrollPane1;
	private JLabel jLabelPassword;
	private JLabel jLabelPort;
	private JFileChooser jFileChooser;
	private File file;
	private JButton jButtonImportar;
    public FTPHandler() {
        initComponents();
        // Desviando msgs do terminal para JTextArea
        printStream = new PrintStream(new OutputStreamCustomizado(CaixaTextoSite));
        System.setOut(printStream);
        System.setErr(printStream);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        Dialogo_CampoVazio = new JDialog();
        Painel_CamposVazios = new JPanel();
        jLabel5 = new JLabel();
        BotaoOK_Dialogo = new JButton();
        jButtonImportar = new JButton();
        PainelBase = new JPanel();
        CampoTextoHost = new JTextField();
        CampoTextoUser = new JTextField();
        CampoTextoPassword = new JTextField();
        CampoTextoPort = new JTextField();
        BotaoConectar = new JButton();
        BotaoEnviar = new JButton();
        jLabelHost = new JLabel();
        jLabelUsername = new JLabel();
        jLabelPassword = new JLabel();
        jLabelPort = new JLabel();
        jScrollPane1 = new JScrollPane();
        CaixaTextoSite = new JTextArea();
        jFileChooser = new JFileChooser();
        
        
        
        jFileChooser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BotaoImportarActionPerformed(e);
			}

		});
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
        setTitle("FTP Client");
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
        
        PainelBase.add(jLabelHost);
        jLabelHost.setBounds(10, 20, 50, 20);
        jLabelHost.setText("Host");
        
        PainelBase.add(CampoTextoHost);
        CampoTextoHost.setBounds(70, 20, 120, 20);
        
        PainelBase.add(jLabelUsername);
        jLabelUsername.setBounds(210, 20, 80, 20);
        jLabelUsername.setText("User");
        
        PainelBase.add(CampoTextoUser);
        CampoTextoUser.setBounds(260, 20, 80, 20);
        
        PainelBase.add(jLabelPassword);
        jLabelPassword.setBounds(350, 20, 80, 20);
        jLabelPassword.setText("Password");
        
        PainelBase.add(CampoTextoPassword);
        CampoTextoPassword.setBounds(430, 20, 60, 20);
        
        PainelBase.add(jLabelPort);
        jLabelPort.setBounds(500, 20, 80, 20);
        jLabelPort.setText("Port");
        
        PainelBase.add(CampoTextoPort);
        CampoTextoPort.setBounds(530, 20, 60, 20);
      
        BotaoConectar.setText("Conect");
        BotaoConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	BotaoConectarActionPerformed(evt);
            }
        });
        PainelBase.add(BotaoConectar);
        BotaoConectar.setBounds(10, 50, 120, 30);

        BotaoEnviar.setText("Enviar");
        BotaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                	if(file.exists()){
                		BotaoEnviarActionPerformed(evt);
                	}else{
                		System.out.println("O Arquivo não foi selecionado");
                	}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
            }
        });
        PainelBase.add(BotaoEnviar);
        BotaoEnviar.setBounds(150, 50, 120, 30);

        PainelBase.add(jButtonImportar);
        jButtonImportar.setBounds(280, 50, 120, 30);
        jButtonImportar.setText("Importar");
        jButtonImportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel jpanel = new JPanel();
				jpanel.setVisible(true);
		         int returnVal = jFileChooser.showOpenDialog(jpanel);

	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                file = jFileChooser.getSelectedFile();
	            } 				
			}
		});
        
        
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

    
    private void BotaoImportarActionPerformed(ActionEvent e) {

                file = jFileChooser.getSelectedFile();
                System.out.println(file.getName());
                //This is where a real application would open the file.
	}
    
    private void BotaoConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoIrActionPerformed
    	try {
	    	String host = CampoTextoHost.getText();
	        String user = CampoTextoUser.getText();
	        String password = CampoTextoPassword.getText();
	        String porta = CampoTextoPort.getText();
	        if(porta.isEmpty()){
	        	porta = "21";
	        }
	        
	        if (!host.isEmpty() && !user.isEmpty() && !password.isEmpty() && !porta.isEmpty()) {
	        	ftpClient = new FTPClient();
	            
	                CaixaTextoSite.setText("Carregando...\n");
	                ftpClient.conectar(host, Integer.parseInt(porta), user, password);
	                ftpClient.listarArquivos();
	                ftpClient.desconectar();
	        } else {
	            Dialogo_CampoVazio.setVisible(true);
	        }
        } catch (Exception ex) {
            Logger.getLogger(HTTPHandle.class.getName()).log(Level.SEVERE, null, ex);
            CaixaTextoSite.setText("Falha ao carregar site");
        }

    }

    
    private void BotaoEnviarActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_BotaoIrActionPerformed
    	
        url = CampoTextoHost.getText();
        String host = CampoTextoHost.getText();
        String user = CampoTextoUser.getText();
        String password = CampoTextoPassword.getText();
        String porta = CampoTextoPort.getText();
        if(porta.isEmpty()){
        	porta = "21";
        }
        ftpClient = new FTPClient();
        ftpClient.conectar(host, Integer.parseInt(porta), user, password);
        ftpClient.enviarArquivo(file);
        ftpClient.listarArquivos();
        ftpClient.desconectar();
    }
    private void BotaoOK_DialogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoOK_DialogoActionPerformed
        Dialogo_CampoVazio.dispose();
    }//GEN-LAST:event_BotaoOK_DialogoActionPerformed


}
