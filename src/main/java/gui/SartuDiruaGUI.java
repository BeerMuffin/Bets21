package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SartuDiruaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField sartudirua;
	private String unekoUsername = null;
	
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
	public SartuDiruaGUI(String u) {
		unekoUsername = u;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Amount of Money:");
		lblNewLabel.setBounds(10, 66, 118, 14);
		contentPane.add(lblNewLabel);
		
		sartudirua = new JTextField();
		sartudirua.setBounds(138, 63, 230, 20);
		contentPane.add(sartudirua);
		sartudirua.setColumns(10);
		
		JButton btnNewButton = new JButton("Input");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double money = Double.parseDouble(sartudirua.getText());
				BLFacade facade = MainGUI.getBusinessLogic();
				facade.inputMoney(unekoUsername, money);
			}
		});
		btnNewButton.setBounds(151, 139, 121, 35);
		contentPane.add(btnNewButton);
	}
}
