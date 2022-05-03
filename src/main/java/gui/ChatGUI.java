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
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JList;


public class ChatGUI extends JFrame{
	private JTextField textField;
	private User unekoUser;
	private DefaultComboBoxModel<Txat>  chatModel= new DefaultComboBoxModel<Txat>();
	private JComboBox<Txat> chat = new JComboBox<Txat>();
	private JScrollPane chatScrollPane = new JScrollPane();
	private DefaultListModel<String> chatMezuaModel = new DefaultListModel<String>();
	private JList<String> chatMezua = new JList<String>();
	private JScrollPane chatMezuaScrollPane = new JScrollPane();
	
	public ChatGUI(User u) {
		unekoUser = u;
		this.setSize(495, 311);
		setTitle("Txateatu");
		getContentPane().setLayout(null);
		chatScrollPane.setBounds(new Rectangle(10, 30, 87, 207));
		getContentPane().add(chatScrollPane);
		chatScrollPane.setViewportView(chat);
		chat.setModel(chatModel);
		BLFacade facade = MainGUI.getBusinessLogic();
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
		
		textField = new JTextField();
		textField.setBounds(139, 205, 293, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Bidali");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(337, 233, 117, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Zure Txatak:");
		lblNewLabel.setBounds(18, 6, 101, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Txat Berria Ireki");
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