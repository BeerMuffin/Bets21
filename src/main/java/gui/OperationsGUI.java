package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.User;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class OperationsGUI extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> operations = new DefaultListModel<String>();
	private JList<String> oper = new JList<String>();
	private String username = null;
	private JScrollPane operationsScrollPane = new JScrollPane();
	
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
	public OperationsGUI(String u) {
		username = u;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		operationsScrollPane.setBounds(new Rectangle(10, 30, 414, 207));
		contentPane.add(operationsScrollPane);
		operationsScrollPane.setViewportView(oper);
		oper.setModel(operations);
		BLFacade facade = MainGUI.getBusinessLogic();
		ArrayList<String> ar = facade.getOperationsDB(username);
		for(String s: ar) {
			operations.addElement(s);
		}
	}
}
