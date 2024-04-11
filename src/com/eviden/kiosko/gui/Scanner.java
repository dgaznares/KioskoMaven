package com.eviden.kiosko.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Scanner extends JFrame {

	private final String FRAME_NAME = "Scanner";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scanner frame = new Scanner();
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
	public Scanner() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("YeS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel backPanel = new JPanel();
		contentPane.add(backPanel);
		backPanel.setLayout(new GridLayout(0, 1, 0, 0));
				
		contentPane.setName(FRAME_NAME);
		
		JPanel northPanel = new JPanel();
		backPanel.add(northPanel);
		northPanel.setLayout(null);
		
		JPanel step1Panel = new JPanel();
		step1Panel.setBorder(null);
		step1Panel.setBounds(1, 1, 358, 119);
		northPanel.add(step1Panel);
		step1Panel.setLayout(null);
		
		JLabel lblStep1 = new JLabel("<html><p>1 - Pon documento en área de scanner con <br> &nbsp &nbsp &nbsp el texto hacia abajo.</p><html>");
		lblStep1.setBounds(10, 22, 364, 86);
		lblStep1.setHorizontalAlignment(SwingConstants.LEFT);
		lblStep1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		step1Panel.add(lblStep1);
		
		JPanel videoStep1Panel = new JPanel();
		videoStep1Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		videoStep1Panel.setBounds(369, 5, 173, 115);
		northPanel.add(videoStep1Panel);
		videoStep1Panel.setLayout(null);
		
		JPanel centralPanel = new JPanel();
		centralPanel.setBorder(null);
		backPanel.add(centralPanel);
		centralPanel.setLayout(null);
		
		JPanel step2Panel = new JPanel();
		step2Panel.setBorder(null);
		step2Panel.setBounds(1, 1, 360, 113);
		centralPanel.add(step2Panel);
		step2Panel.setLayout(null);
		
		JLabel lblAcceso = new JLabel("2 - Pulsar");
		lblAcceso.setBounds(10, 22, 100, 70);
		lblAcceso.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcceso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		step2Panel.add(lblAcceso);
		
		JButton btnScan = new JButton("SCANEAR");
		btnScan.setBounds(92, 30, 127, 59);
		step2Panel.add(btnScan);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(224, 50, 128, 20);
		step2Panel.add(progressBar);
		
		JPanel buttonStep2Panel = new JPanel();
		buttonStep2Panel.setBorder(null);
		buttonStep2Panel.setBounds(369, 5, 173, 112);
		centralPanel.add(buttonStep2Panel);
		buttonStep2Panel.setLayout(null);
		
		JPanel southPanel = new JPanel();
		backPanel.add(southPanel);
		southPanel.setLayout(null);
		
		JPanel step3Panel = new JPanel();
		step3Panel.setBounds(0, 0, 365, 114);
		southPanel.add(step3Panel);
		step3Panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><p>3 - Puedes consultar los documentos en &nbsp &nbsp &nbsp ARCHIVOS.</p><html>");
		lblNewLabel.setBounds(10, 45, 304, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		step3Panel.add(lblNewLabel);
		
		JPanel buttonStep3panel = new JPanel();
		buttonStep3panel.setBounds(375, 5, 167, 109);
		southPanel.add(buttonStep3panel);
		buttonStep3panel.setLayout(null);
		
		JButton btnFiles = new JButton("ARCHIVOS");
		btnFiles.setBounds(21, 25, 113, 56);
		buttonStep3panel.add(btnFiles);
	}
}
