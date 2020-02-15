package com.ucab.interfazEjemplo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

public class VentanaEjemplo {

	private JFrame frmSolitario;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * @wbp.nonvisual location=-180,529
	 */
	private final JSeparator separator = new JSeparator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjemplo window = new VentanaEjemplo();
					window.frmSolitario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaEjemplo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolitario = new JFrame();
		frmSolitario.setTitle("2048 solitario");
		frmSolitario.getContentPane().setBackground(Color.BLACK);
		frmSolitario.getContentPane().setLayout(null);
		
		JButton button = new JButton("");
		button.setBounds(17, 60, 225, 349);
		frmSolitario.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(501, 60, 225, 349);
		frmSolitario.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(259, 60, 225, 349);
		frmSolitario.getContentPane().add(btnNewButton_1);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(550, 420, 176, 123);
		frmSolitario.getContentPane().add(button_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(17, 494, 170, 49);
		frmSolitario.getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(17, 29, 86, 20);
		frmSolitario.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(259, 29, 225, 20);
		frmSolitario.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(587, 29, 86, 20);
		frmSolitario.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		frmSolitario.setBackground(new Color(0, 0, 0));
		frmSolitario.setBounds(100, 100, 762, 593);
		frmSolitario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
