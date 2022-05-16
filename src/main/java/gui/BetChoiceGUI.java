package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Event;
import domain.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BetChoiceGUI extends JFrame {

	private JPanel contentPane;
	private String unekoUsername;
	/**
	 * Create the frame.
	 */
	public BetChoiceGUI(Vector<Event> ev, String u) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.unekoUsername = u;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SingleBet"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new BetGUI(new Vector<Event>(), unekoUsername);
				a.setVisible(true);
			}
		});
		btnNewButton.setBounds(39, 53, 159, 145);
		contentPane.add(btnNewButton);
		
		JButton btnMultipleBet = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MultipleBet"));
		btnMultipleBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new MultipleBetGUI(new Vector<Event>(), unekoUsername);
				a.setVisible(true);
			}
		});
		btnMultipleBet.setBounds(232, 53, 159, 145);
		contentPane.add(btnMultipleBet);
	}
}
