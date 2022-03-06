package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Admin;
import domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class ErregistratuGUI extends JFrame{
	private JPanel contentPane;
	private JPasswordField pass2;
	private JTextField username;
	
	 private static BLFacade appFacadeInterface;
	 private JTextField name;
	 private JTextField email;
	 private JPasswordField pass1;
	 private JTextField day;
	 private JTextField month;
	 private JTextField year;
	 private final ButtonGroup buttonGroup = new ButtonGroup();
		
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
		
		pass2 = new JPasswordField();
		pass2.setBounds(136, 134, 138, 20);
		contentPane.add(pass2);
		
		username = new JTextField();
		username.setBounds(115, 49, 162, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JRadioButton user = new JRadioButton("User");
		buttonGroup.add(user);
		user.setBounds(204, 235, 103, 23);
		contentPane.add(user);
		
		JRadioButton admin = new JRadioButton("Admin");
		buttonGroup.add(admin);
		admin.setBounds(57, 235, 103, 23);
		contentPane.add(admin);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String izen = name.getText();
				String userna = username.getText();
				String emaila = email.getText();
				String pasahitz1 = String.valueOf(pass1.getPassword());
				String pasahitz2 = String.valueOf(pass2.getPassword());
				String egun = day.getText();
				String hila = month.getText();
				String urte = year.getText();
				BLFacade facade = MainGUI.getBusinessLogic();
				if(user.isSelected()) {
				if(pasahitz1.equals(pasahitz2)) {
					User u = new User(izen, userna, emaila, pasahitz1, egun, hila, urte);
					if(facade.registerUser(u)) {
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(register, "Erregistratu egin zara");
						JFrame a = new LoginGUI();
						a.setVisible(true);
					}else {
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(register, "Erabiltzaile hori existitzen da");
					}
				}else {
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(register, "Pasahitzak desberdinak dira");
				}
			}	else if(admin.isSelected()) {
				if(pasahitz1.equals(pasahitz2)) {
					Admin a = new Admin(izen, userna, emaila, pasahitz1, egun, hila, urte);
					if(facade.registerAdmin(a)) {
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(register, "Erregistratu egin zara");
						JFrame b = new LoginGUI();
						b.setVisible(true);
					}else {
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(register, "Administratzaile hori existitzen da");
					}
				}else {
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(register, "Pasahitzak desberdinak dira");
				}
			}
			}
		});
		register.setBounds(344, 249, 89, 23);
		contentPane.add(register);
		
		JLabel lblNewLabel_2 = new JLabel("Repeat Password:");
		lblNewLabel_2.setBounds(22, 136, 132, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email adress:");
		lblNewLabel_3.setBounds(22, 82, 111, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		lblNewLabel_4.setBounds(22, 24, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(115, 17, 162, 20);
		contentPane.add(name);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(115, 80, 162, 20);
		contentPane.add(email);
		
		pass1 = new JPasswordField();
		pass1.setBounds(115, 107, 162, 20);
		contentPane.add(pass1);
		
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
		
		day = new JTextField();
		day.setColumns(10);
		day.setBounds(57, 189, 67, 24);
		contentPane.add(day);
		
		month = new JTextField();
		month.setColumns(10);
		month.setBounds(173, 189, 67, 24);
		contentPane.add(month);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(280, 188, 67, 24);
		contentPane.add(year);
	}
}



