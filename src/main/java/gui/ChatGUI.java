package gui;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTextField;

import businessLogic.BLFacade;
import domain.Txat;
import domain.User;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JList;


public class ChatGUI extends JFrame{
	private JTextField bidali;
	private User unekoUser;
	private DefaultComboBoxModel<Txat>  chatModel= new DefaultComboBoxModel<Txat>();
	private JComboBox<Txat> chat = new JComboBox<Txat>();
	private JScrollPane chatScrollPane = new JScrollPane();
	private DefaultListModel<String> chatMezuaModel = new DefaultListModel<String>();
	private JList<String> chatMezua = new JList<String>();
	private JScrollPane chatMezuaScrollPane = new JScrollPane();
	
	public ChatGUI(User u) {
		unekoUser = u;
		BLFacade facade = MainGUI.getBusinessLogic();
		this.setSize(495, 311);
		setTitle("Txateatu");
		getContentPane().setLayout(null);
		chatScrollPane.setBounds(new Rectangle(10, 43, 87, 207));
		getContentPane().add(chatScrollPane);
		chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chatMezuaModel.removeAllElements();
				Txat txat = (Txat) chat.getSelectedItem();
				ArrayList<String> arr = facade.getTxatMezuakDB(txat);
				for(String s: arr) {
					chatMezuaModel.addElement(s);
				}
			}
		});
		chatScrollPane.setViewportView(chat);
		chat.setModel(chatModel);
		
		ArrayList<Txat> txats = facade.getTxatsDB(unekoUser.getUsername());
		for(Txat t: txats) {
			if(unekoUser.getUsername().equals(t.getUser1().getUsername())) {
				chatModel.addElement(t);
			}else {
				User lag = t.getUser1();
				t.setUser1(u);
				t.setUser2(lag);
				chatModel.addElement(t);
			}
			
		}
		
		
		chatMezuaScrollPane.setBounds(new Rectangle(124, 43, 345, 151));
		getContentPane().add(chatMezuaScrollPane);
		chatMezuaScrollPane.setViewportView(chatMezua);
		chatMezua.setModel(chatMezuaModel);
		
		bidali = new JTextField();
		bidali.setBounds(124, 205, 345, 26);
		getContentPane().add(bidali);
		bidali.setColumns(10);
		
		JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Send"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				String message = bidali.getText();
				Txat txat = (Txat) chat.getSelectedItem();
				facade.addMessage(txat, unekoUser.getUsername()+": "+message);
				chatMezuaModel.removeAllElements();
				ArrayList<String> arr = facade.getTxatMezuakDB(txat);
				for(String s: arr) {
					chatMezuaModel.addElement(s);
				}
				bidali.setText("");
			}
		});
		btnNewButton.setBounds(337, 233, 117, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("YourChats"));
		lblNewLabel.setBounds(18, 6, 101, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton(ResourceBundle.getBundle("Etiquetas").getString("NewChat"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new NewChatGUI(unekoUser);
				a.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(303, 6, 129, 23);
		getContentPane().add(btnNewButton_1);
	}
}