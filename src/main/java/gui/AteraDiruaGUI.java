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
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class AteraDiruaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField ateradirua;
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
	public AteraDiruaGUI(String u) {
		unekoUsername = u;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("AmountMoney"));
		lblNewLabel.setBounds(10, 66, 118, 14);
		contentPane.add(lblNewLabel);
		
		ateradirua = new JTextField();
		ateradirua.setBounds(138, 63, 230, 20);
		contentPane.add(ateradirua);
		ateradirua.setColumns(10);
		
		JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Output"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double money = Double.parseDouble(ateradirua.getText());
				BLFacade facade = MainGUI.getBusinessLogic();
				facade.outputMoney(unekoUsername, money);
				String s = "Dirua Atera du: " + ateradirua.getText() + "€";
				facade.addOperation(unekoUsername, s);
			}
		});
		btnNewButton.setBounds(151, 139, 121, 35);
		contentPane.add(btnNewButton);
	}
}
