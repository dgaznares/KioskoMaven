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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Yes extends JFrame {

	private final String FRAME_NAME = "YeS";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yes frame = new Yes();
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
	public Yes() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("YeS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 408);
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
		step1Panel.setBounds(1, 1, 384, 135);
		northPanel.add(step1Panel);
		step1Panel.setLayout(null);
		
		JLabel lblStep1 = new JLabel("1 - Sitúa la llave 2FA en el soporte \"llave 2FA\".");
		lblStep1.setBounds(10, 11, 370, 113);
		lblStep1.setHorizontalAlignment(SwingConstants.LEFT);
		lblStep1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		step1Panel.add(lblStep1);
		
		JPanel videoStep1Panel = new JPanel();
		videoStep1Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		videoStep1Panel.setBounds(388, 0, 169, 112);
		northPanel.add(videoStep1Panel);
		videoStep1Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel centralPanel = new JPanel();
		centralPanel.setBorder(null);
		backPanel.add(centralPanel);
		centralPanel.setLayout(null);
		
		JPanel step2Panel = new JPanel();
		step2Panel.setBorder(null);
		step2Panel.setBounds(1, 1, 383, 129);
		centralPanel.add(step2Panel);
		step2Panel.setLayout(null);
		
		JLabel lblAcceso = new JLabel("2 - Acceso aplicativo YeS.");
		lblAcceso.setBounds(10, 11, 368, 109);
		lblAcceso.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcceso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		step2Panel.add(lblAcceso);
		
		JPanel buttonStep2Panel = new JPanel();
		buttonStep2Panel.setBorder(null);
		buttonStep2Panel.setBounds(388, 11, 169, 95);
		centralPanel.add(buttonStep2Panel);
		buttonStep2Panel.setLayout(null);
		
		JButton btnYes = new JButton("YeS");
		btnYes.setBounds(30, 11, 110, 77);
		buttonStep2Panel.add(btnYes);
		
		JPanel southPanel = new JPanel();
		backPanel.add(southPanel);
		southPanel.setLayout(new BorderLayout(0, 0));
	}
}
