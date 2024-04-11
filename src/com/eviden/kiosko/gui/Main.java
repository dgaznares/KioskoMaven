package com.eviden.kiosko.gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.eviden.kiosko.services.Utils;


public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel backPanel = new JPanel();
		contentPane.add(backPanel);
		backPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		backPanel.add(northPanel, BorderLayout.NORTH);
		
		JPanel centralPanel = new JPanel();
		centralPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		backPanel.add(centralPanel, BorderLayout.CENTER);
		centralPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		centralPanel.add(mainTabbedPane);
		
		JPanel southPanel = new JPanel();
		backPanel.add(southPanel, BorderLayout.SOUTH);
		
		JPanel leftPanel = new JPanel();
		backPanel.add(leftPanel, BorderLayout.WEST);
		
		JPanel rightPanel = new JPanel();
		backPanel.add(rightPanel, BorderLayout.EAST);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[]{73, 73, 0};
		gbl_rightPanel.rowHeights = new int[]{46, 46, 46, 46, 46, 0};
		gbl_rightPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_rightPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		rightPanel.setLayout(gbl_rightPanel);
		
		JButton btnWarnigs = new JButton("Avisos");
		btnWarnigs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					if(desktop.isSupported(Desktop.Action.BROWSE)){						
						try {
							//desktop.browse(new URI("https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/"));
							desktop.browse(new URI("https://docs.spring.io/spring-boot/docs/3.2.3/reference/pdf/spring-boot-reference.pdf"));
						} catch (IOException | URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			}
		});
		
		JButton btnYes = new JButton("YeS");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					boolean encontrado = Utils.ifExistTabb(mainTabbedPane, "YeS");
					if (!encontrado) {
						Yes yes = new Yes();					
						mainTabbedPane.addTab("YeS", yes.getContentPane());
					}					
				}
				catch(Exception ex) {
					
				}
			}
		});
		GridBagConstraints gbc_btnYes = new GridBagConstraints();
		gbc_btnYes.fill = GridBagConstraints.BOTH;
		gbc_btnYes.insets = new Insets(0, 0, 5, 5);
		gbc_btnYes.gridx = 0;
		gbc_btnYes.gridy = 0;
		rightPanel.add(btnYes, gbc_btnYes);
		GridBagConstraints gbc_btnWarnigs = new GridBagConstraints();
		gbc_btnWarnigs.fill = GridBagConstraints.BOTH;
		gbc_btnWarnigs.insets = new Insets(0, 0, 5, 0);
		gbc_btnWarnigs.gridx = 1;
		gbc_btnWarnigs.gridy = 0;
		rightPanel.add(btnWarnigs, gbc_btnWarnigs);
		
		JButton btnExit = new JButton("Salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    // Se pide una confirmación antes de finalizar el programa
				int option = JOptionPane.showConfirmDialog(
						contentPane, 
					"¿Estás seguro de que quieres cerrar la aplicación?",
					"Confirmación de cierre", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		JButton btnScanner = new JButton("Scanner");
		btnScanner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean encontrado = Utils.ifExistTabb(mainTabbedPane, "Scanner");
					if (!encontrado) {
						Scanner scanner = new Scanner();					
						mainTabbedPane.addTab("Scanner", scanner.getContentPane());
					}
				}
				catch(Exception ex) {					
				}
			}
		});
		GridBagConstraints gbc_btnScanner = new GridBagConstraints();
		gbc_btnScanner.fill = GridBagConstraints.BOTH;
		gbc_btnScanner.insets = new Insets(0, 0, 5, 5);
		gbc_btnScanner.gridx = 0;
		gbc_btnScanner.gridy = 1;
		rightPanel.add(btnScanner, gbc_btnScanner);
		
		JButton btnHelp = new JButton("Ayuda");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      try {
			            // Inicia el JFileChooser
//			            JFileChooser fc = new JFileChooser();
			            // Se crea un filtro de extensiones para que solamente pueda seleccionar archivos PDF
//			            javax.swing.filechooser.FileFilter ff = new FileNameExtensionFilter("C:\\workspace-SEAT\\Kiosko\\resources\\help\\conexión-api-motor","pdf");
			            // Se asigna el filtro al objeto JFileChooser
//			            fc.setFileFilter(ff);
			            // Se muestra la ventana de JFilChooser
//			            fc.showOpenDialog(null);
			            // Se asigna el archivo seleccionado a un objeto tipo File
//			            File archivoPDF = fc.getSelectedFile();
			            //File archivoPDF = new File("C:\\workspace-SEAT\\Kiosko\\resources\\help\\conexión-api-motor.pdf");
			    	  	//File archivoPDF = new File("./help/conexión-api-motor.pdf");
			    	  	File archivoPDF = new File("./resources/conexión-api-motor.pdf");
			            // Se sustituye la ruta por la ruta absoluta obtenida del objeto File
			    	  	String[] list = archivoPDF.list();
			            Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,"
			                    + "ShellExec_RunDLL " + archivoPDF.getAbsolutePath());
			        } catch (Exception evvv) {
			            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda,"
			                    + " probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
			        }	
			}
		});
		GridBagConstraints gbc_btnHelp = new GridBagConstraints();
		gbc_btnHelp.fill = GridBagConstraints.BOTH;
		gbc_btnHelp.insets = new Insets(0, 0, 5, 0);
		gbc_btnHelp.gridx = 1;
		gbc_btnHelp.gridy = 1;
		rightPanel.add(btnHelp, gbc_btnHelp);
		
		JButton btnFiles = new JButton("Archivos");
		GridBagConstraints gbc_btnFiles = new GridBagConstraints();
		gbc_btnFiles.fill = GridBagConstraints.BOTH;
		gbc_btnFiles.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiles.gridx = 0;
		gbc_btnFiles.gridy = 2;
		rightPanel.add(btnFiles, gbc_btnFiles);
		
		JButton btnMUBI = new JButton("MUBI");
		GridBagConstraints gbc_btnMUBI = new GridBagConstraints();
		gbc_btnMUBI.fill = GridBagConstraints.BOTH;
		gbc_btnMUBI.insets = new Insets(0, 0, 5, 0);
		gbc_btnMUBI.gridx = 1;
		gbc_btnMUBI.gridy = 2;
		rightPanel.add(btnMUBI, gbc_btnMUBI);
		
		JButton btnHide_1 = new JButton("");
		btnHide_1.setEnabled(false);		
		GridBagConstraints gbc_btnHide_1 = new GridBagConstraints();
		gbc_btnHide_1.fill = GridBagConstraints.BOTH;
		gbc_btnHide_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnHide_1.gridx = 0;
		gbc_btnHide_1.gridy = 3;
		rightPanel.add(btnHide_1, gbc_btnHide_1);
		
		JButton btnHide_2 = new JButton("");
		btnHide_2.setEnabled(false);
		
		GridBagConstraints gbc_btnHide_2 = new GridBagConstraints();
		gbc_btnHide_2.fill = GridBagConstraints.BOTH;
		gbc_btnHide_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnHide_2.gridx = 1;
		gbc_btnHide_2.gridy = 3;
		rightPanel.add(btnHide_2, gbc_btnHide_2);
		
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.fill = GridBagConstraints.BOTH;
		gbc_btnExit.insets = new Insets(0, 0, 0, 5);
		gbc_btnExit.gridx = 1;
		gbc_btnExit.gridy = 4;
		rightPanel.add(btnExit, gbc_btnExit);
		
		JButton btnHide_3 = new JButton("");
		btnHide_3.setEnabled(false);
		GridBagConstraints gbc_btnHide_3 = new GridBagConstraints();
		gbc_btnHide_3.fill = GridBagConstraints.BOTH;
		gbc_btnHide_3.gridx = 0;
		gbc_btnHide_3.gridy = 4;
		rightPanel.add(btnHide_3, gbc_btnHide_3);
	}

}
