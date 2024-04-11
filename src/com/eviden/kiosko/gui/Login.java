package com.eviden.kiosko.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Login {

	private JFrame ventana;
	private JTextField textNis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.ventana.setVisible(true);
					window.ventana.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventana = new JFrame();
		ventana.setLocationRelativeTo(null);
		ventana.setBounds(450, 300, 629, 425);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel backPanel = new JPanel();
		backPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ventana.getContentPane().add(backPanel);
		backPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		backPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel suthPanel = new JPanel();
		backPanel.add(suthPanel, BorderLayout.SOUTH);
		
		JPanel leftPanel = new JPanel();
		backPanel.add(leftPanel, BorderLayout.WEST);
		
		JPanel rigthPanel = new JPanel();
		backPanel.add(rigthPanel, BorderLayout.EAST);
		
		JPanel centralPanel = new JPanel();
		centralPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		backPanel.add(centralPanel, BorderLayout.CENTER);
		
		JPanel informationPanel = new JPanel();
		informationPanel.setBounds(179, 99, 219, 132);
		informationPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		informationPanel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		informationPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel nisPanel = new JPanel();
		informationPanel.add(nisPanel);
		nisPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNis = new JLabel("Introduce tu Nis:");
		nisPanel.add(lblNis);
		lblNis.setHorizontalAlignment(SwingConstants.LEFT);
		lblNis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textNis = new JTextField();
		nisPanel.add(textNis);
		textNis.setHorizontalAlignment(SwingConstants.LEFT);
		textNis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 if(textNis.getText().length() >= 8)
				    {
				        e.consume();
				    }
			}
		});
		textNis.setColumns(10);
		
		JPanel buttonsPanel = new JPanel();
		informationPanel.add(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(0, 2, 5, 0));
		
		JButton btnClean = new JButton("Limpiar");
		buttonsPanel.add(btnClean);
		
		JButton btnValidate = new JButton("Validar");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.setVisible(true);
				main.setLocationRelativeTo(null);
			}
		});
		centralPanel.setLayout(null);
		buttonsPanel.add(btnValidate);
		centralPanel.add(informationPanel);
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNis.setText("");
			}
		});

	}
}
