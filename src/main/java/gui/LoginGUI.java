package gui;


import java.awt.EventQueue;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Admin;
import domain.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	private JTextField username;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
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
		
		pass = new JPasswordField();
		pass.setBounds(115, 92, 162, 20);
		contentPane.add(pass);
		
		username = new JTextField();
		username.setBounds(115, 49, 162, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JRadioButton user = new JRadioButton("User");
		buttonGroup.add(user);
		user.setBounds(115, 131, 67, 23);
		contentPane.add(user);
		
		JRadioButton admin = new JRadioButton("Admin");
		buttonGroup.add(admin);
		admin.setBounds(210, 131, 67, 23);
		contentPane.add(admin);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String erabiltzaile = username.getText();
				String pasahitz = String.valueOf(pass.getPassword());
				BLFacade facade = MainGUI.getBusinessLogic();
				if(user.isSelected()) {
					User u = facade.getUserByUsername(erabiltzaile);
					if(u != null) {
						if(pasahitz.equals(u.getPassword())){
							JFrame a = new UserGUI();
							a.setVisible(true);
						}else {
							JOptionPane jop = new JOptionPane();
							jop.showMessageDialog(login, "Pasahitza ez da hori");
						}
					}else {
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(login, "Erabiltzaile hori ez da existitzen");
					}
				}
				else if(admin.isSelected()) {
					Admin a = facade.getAdminByUsername(erabiltzaile);
					if(a != null) {
						if(pasahitz.equals(a.getPassword())) {
							JFrame b = new AdminGUI();
							b.setVisible(true);
						}else {
							JOptionPane jop = new JOptionPane();
							jop.showMessageDialog(login, "Pasahitza ez da hori");
						}
					}else {
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(login, "Administratzaile hori ez da existitzen");
					}
				}
			}
		});
		login.setBounds(150, 164, 89, 23);
		contentPane.add(login);
		
		JLabel lblNewLabel_2 = new JLabel("New Account?");
		lblNewLabel_2.setBounds(10, 215, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton register = new JButton("Register");
		register.setBounds(10, 227, 89, 23);
		contentPane.add(register);
	}
}
