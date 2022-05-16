package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.User;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PermissionsGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public PermissionsGUI() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("User")+":");
		lblNewLabel.setBounds(0, 31, 89, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(101, 28, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel queryText = new JLabel("");
		queryText.setBounds(230, 79, 94, 14);
		contentPane.add(queryText);
		
		JLabel betText = new JLabel("");
		betText.setBounds(230, 123, 94, 14);
		contentPane.add(betText);
		
		JLabel chatText = new JLabel("");
		chatText.setBounds(230, 164, 94, 14);
		contentPane.add(chatText);
		
		JLabel moneyText = new JLabel("");
		moneyText.setBounds(230, 201, 94, 14);
		contentPane.add(moneyText);
		
		JRadioButton query = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				User u = facade.getUserByUsername(textField.getText());
				if(query.isSelected()) {
					facade.setQueryQuestions(u.getUsername(), true);
					queryText.setText(ResourceBundle.getBundle("Etiquetas").getString("Permitted"));
					queryText.setForeground(Color.green);
				}else {
					facade.setQueryQuestions(u.getUsername(), false);
					queryText.setText(ResourceBundle.getBundle("Etiquetas").getString("Denied"));
					queryText.setForeground(Color.red);
				}
			}
		});
		query.setBounds(73, 75, 144, 23);
		contentPane.add(query);
		
		JRadioButton bet = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("Bet"));
		bet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				User u = facade.getUserByUsername(textField.getText());
				if(bet.isSelected()) {
					facade.setBet(u.getUsername(), true);
					betText.setText(ResourceBundle.getBundle("Etiquetas").getString("Permitted"));
					betText.setForeground(Color.green);
				}else {
					facade.setBet(u.getUsername(), false);
					betText.setText(ResourceBundle.getBundle("Etiquetas").getString("Denied"));
					betText.setForeground(Color.red);
				}
			}
		});
		bet.setBounds(73, 119, 144, 23);
		contentPane.add(bet);
		

		JRadioButton chat = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("Chat"));
		chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				User u = facade.getUserByUsername(textField.getText());
				if(chat.isSelected()) {
					facade.setChat(u.getUsername(), true);
					chatText.setText(ResourceBundle.getBundle("Etiquetas").getString("Permitted"));
					chatText.setForeground(Color.green);
				}else {
					facade.setChat(u.getUsername(), false);
					chatText.setText(ResourceBundle.getBundle("Etiquetas").getString("Denied"));
					chatText.setForeground(Color.red);
				}
			}
		});
		chat.setBounds(73, 160, 144, 23);
		contentPane.add(chat);
		

		JRadioButton movemoney = new JRadioButton(ResourceBundle.getBundle("Etiquetas").getString("MoveMoney"));
		movemoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				User u = facade.getUserByUsername(textField.getText());
				if(movemoney.isSelected()) {
					facade.setMoveMoney(u.getUsername(), true);
					moneyText.setText(ResourceBundle.getBundle("Etiquetas").getString("Permitted"));
					moneyText.setForeground(Color.green);
				}else {
					facade.setMoveMoney(u.getUsername(), false);
					moneyText.setText(ResourceBundle.getBundle("Etiquetas").getString("Denied"));
					moneyText.setForeground(Color.red);
				}
			}
		});
		movemoney.setBounds(73, 197, 144, 23);
		contentPane.add(movemoney);
	
		JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Search"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				User u = facade.getUserByUsername(textField.getText());
				if(u != null) {
				if(u.isToQueryQuestions()) {
					query.setSelected(true);
					queryText.setText(ResourceBundle.getBundle("Etiquetas").getString("Permitted"));
					queryText.setForeground(Color.green);
				}else {
					query.setSelected(false);
					queryText.setText(ResourceBundle.getBundle("Etiquetas").getString("Denied"));
					queryText.setForeground(Color.red);
				}
				if(u.isToBet()) {
					bet.setSelected(true);
					betText.setText(ResourceBundle.getBundle("Etiquetas").getString("Permitted"));
					betText.setForeground(Color.green);
				}else {
					bet.setSelected(false);
					betText.setText(ResourceBundle.getBundle("Etiquetas").getString("Denied"));
					betText.setForeground(Color.red);
				}
				if(u.isToChat()) {
					chat.setSelected(true);
					chatText.setText(ResourceBundle.getBundle("Etiquetas").getString("Permitted"));
					chatText.setForeground(Color.green);
				}else {
					chat.setSelected(false);
					chatText.setText(ResourceBundle.getBundle("Etiquetas").getString("Denied"));
					chatText.setForeground(Color.red);
				}
				if(u.isToMoveMoney()) {
					movemoney.setSelected(true);
					moneyText.setText(ResourceBundle.getBundle("Etiquetas").getString("Permitted"));
					moneyText.setForeground(Color.green);
				}else {
					movemoney.setSelected(false);
					moneyText.setText(ResourceBundle.getBundle("Etiquetas").getString("Denied"));
					moneyText.setForeground(Color.red);
				}
				}else {
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(btnNewButton, "Erabiltzaile hori ez da existitzen");
				}
			}
		});
		btnNewButton.setBounds(290, 27, 89, 23);
		contentPane.add(btnNewButton);
	}
}
