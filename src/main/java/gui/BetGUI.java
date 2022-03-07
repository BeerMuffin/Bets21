package gui;


import java.awt.EventQueue;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Event;

import javax.swing.JButton;





public class BetGUI extends JFrame {

	private JPanel contentPane;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KuotakGUI frame = new KuotakGUI(new Vector<Event>());
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
	public BetGUI() {
		setTitle(ResourceBundle.getBundle("Etiquetas").getString("Bet")); //$NON-NLS-1$ //$NON-NLS-2$
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	}
}
