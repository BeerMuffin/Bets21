package gui;


import java.awt.EventQueue;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("User"));
		lblNewLabel.setBounds(48, 52, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(48, 95, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 92, 162, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(115, 49, 162, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("User");
		rdbtnNewRadioButton.setBounds(115, 131, 67, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Admin");
		rdbtnNewRadioButton_1.setBounds(210, 131, 67, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(150, 164, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New Account?");
		lblNewLabel_2.setBounds(10, 215, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}

