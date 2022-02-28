package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErregistratuGUI extends JFrame{
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	
	 private static BLFacade appFacadeInterface;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 private JPasswordField passwordField_1;
	 private JTextField textField_3;
	 private JTextField textField_4;
	 private JTextField textField_5;
		
		public static BLFacade getBusinessLogic(){
			return appFacadeInterface;
		}
		 
		public static void setBussinessLogic (BLFacade afi){
			appFacadeInterface=afi;
		}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErregistratuGUI frame = new ErregistratuGUI();
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
	public ErregistratuGUI() {
		setTitle("Register: New User");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(22, 52, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(22, 110, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 134, 138, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(115, 49, 162, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("User");
		rdbtnNewRadioButton.setBounds(204, 235, 103, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Admin");
		rdbtnNewRadioButton_1.setBounds(57, 235, 103, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(344, 249, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Repeat Password:");
		lblNewLabel_2.setBounds(22, 136, 132, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email adress:");
		lblNewLabel_3.setBounds(22, 82, 111, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		lblNewLabel_4.setBounds(22, 24, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 17, 162, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 80, 162, 20);
		contentPane.add(textField_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(115, 107, 162, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_5 = new JLabel("BirthDay:");
		lblNewLabel_5.setBounds(22, 164, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Day:");
		lblNewLabel_6.setBounds(22, 194, 38, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Month:");
		lblNewLabel_6_1.setBounds(127, 194, 61, 16);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Year:");
		lblNewLabel_6_2.setBounds(245, 194, 61, 16);
		contentPane.add(lblNewLabel_6_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(57, 189, 67, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(173, 189, 67, 24);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(280, 188, 67, 24);
		contentPane.add(textField_5);
	}
}



