package gui;

/**
 * @author Software Engineering teachers
 */


import javax.swing.*;

import domain.Event;
import domain.User;
import businessLogic.BLFacade;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JButton jButtonCreateQuery = null;
	private JButton query = null;
	String unekoUsername = null;
	User unekoUser = null;
    private static BLFacade appFacadeInterface;
	
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	 
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}
	protected JLabel jLabelSelectOption;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton Bet;
	
	/**
	 * This is the default constructor
	 */
	BLFacade facade = MainGUI.getBusinessLogic();
	public UserGUI(String u) {
		super();
		unekoUsername = u;
		unekoUser = facade.getUserByUsername(unekoUsername);
		addWindowListener(new WindowAdapter() {
			
		});

		initialize();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		// this.setSize(271, 295);
		this.setSize(495, 290);
		this.setContentPane(getJContentPane());
		this.setTitle("UserGUI");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getLblNewLabel());
			jContentPane.add(getBoton3());
			
			JButton bet = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Bet")); //$NON-NLS-1$ //$NON-NLS-2$
			bet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame a = new BetGUI();
					a.setVisible(true);
				}
			});
			bet.setBounds(245, 48, 195, 82);
			jContentPane.add(bet);
			
			JButton inputmoney = new JButton();
			inputmoney.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame a = new SartuDiruaGUI(unekoUsername);
					a.setVisible(true);
				}
			});
			inputmoney.setText(ResourceBundle.getBundle("Etiquetas").getString("UserGUI.inputmoney.text")); //$NON-NLS-1$ //$NON-NLS-2$
			inputmoney.setBounds(27, 147, 195, 82);
			jContentPane.add(inputmoney);
			
			JButton outputmoney = new JButton();
			outputmoney.setText(ResourceBundle.getBundle("Etiquetas").getString("UserGUI.outputmoney.text")); //$NON-NLS-1$ //$NON-NLS-2$
			outputmoney.setBounds(245, 147, 195, 82);
			jContentPane.add(outputmoney);
			
			JLabel lblNewLabel = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("UserGUI.lblNewLabel.text")); //$NON-NLS-1$ //$NON-NLS-2$
			lblNewLabel.setBounds(4, 11, 46, 14);
			jContentPane.add(lblNewLabel);
			
			JLabel money = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("UserGUI.lblNewLabel_1.text")); //$NON-NLS-1$ //$NON-NLS-2$
			money.setBounds(54, 11, 78, 14);
			jContentPane.add(money);
			money.setText(Double.toString(unekoUser.getMoney()));
			
			BLFacade blf = MainGUI.getBusinessLogic();
			JButton button = new JButton("Update");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					User u = blf.getUserByUsername(unekoUsername);
					money.setText(Double.toString(u.getMoney()));
				}
			});
			button.setBounds(367, 7, 89, 23);
			jContentPane.add(button);
		}
		return jContentPane;
	}


	/**
	 * This method initializes boton1
	 * 
	 * @return javax.swing.JButton
	 */
	
	/**
	 * This method initializes boton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton3() {
		if (query == null) {
			query = new JButton();
			query.setBounds(27, 48, 195, 82);
			query.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
			query.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFrame a = new FindQuestionsGUI();

					a.setVisible(true);
				}
			});
		}
		return query;
	}
	

	private JLabel getLblNewLabel() {
		if (jLabelSelectOption == null) {
			jLabelSelectOption = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
			jLabelSelectOption.setBounds(4, 1, 475, 62);
			jLabelSelectOption.setFont(new Font("Tahoma", Font.BOLD, 13));
			jLabelSelectOption.setForeground(Color.BLACK);
			jLabelSelectOption.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelSelectOption;
	}
	
	private void redibujar() {
		jLabelSelectOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		query.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
		jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
		Bet.setText(ResourceBundle.getBundle("Etiquetas").getString("Bet"));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}
} // @jve:decl-index=0:visual-constraint="0,0"