package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Txat;
import domain.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewChatGUI extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField mezua;
	private User unekoUser = null;
	
	 private static BLFacade appFacadeInterface;
		
		public static BLFacade getBusinessLogic(){
			return appFacadeInterface;
		}
		 
		public static void setBussinessLogic (BLFacade afi){
			appFacadeInterface=afi;
		}
	/**
	 * Create the frame.
	 */
	public NewChatGUI(User u) {
		unekoUser = u;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Erabiltzailea:");
		lblNewLabel.setBounds(10, 45, 78, 14);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(96, 42, 301, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mezua:");
		lblNewLabel_1.setBounds(10, 99, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		mezua = new JTextField();
		mezua.setBounds(96, 96, 328, 20);
		contentPane.add(mezua);
		mezua.setColumns(10);
		
		JButton btnNewButton = new JButton("Txat Hasi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				String username = user.getText();
				String message = unekoUser.getUsername()+": "+ mezua.getText();
				User hartzaile = facade.getUserByUsername(username);
				if(hartzaile != null) {
					Txat txat = new Txat(unekoUser, hartzaile);
					txat.addMezua(message);
					System.out.println(txat.getMezuak());
					facade.createTxat(txat);
					facade.addTxat(unekoUser.getUsername(), txat);
					facade.addTxat(hartzaile.getUsername(), txat);
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(btnNewButton, "Txat Berria Sortu Da");
				}else {
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(btnNewButton, "Erabiltzaile hori ez da existitzen");
				}
			}
		});
		btnNewButton.setBounds(171, 162, 104, 39);
		contentPane.add(btnNewButton);
	}
}
