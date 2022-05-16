package gui;

import java.text.DateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import businessLogic.BLFacade;
import configuration.UtilDate;
import domain.Bet;
import domain.Event;
import domain.MultipleBet;
import domain.PartialBet;
import domain.Question;
import domain.Result;
import domain.User;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

public class MultipleBetGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JComboBox<Event> jComboBoxEvents = new JComboBox<Event>();
	DefaultComboBoxModel<Event> modelEvents = new DefaultComboBoxModel<Event>();
	
	private JComboBox<Question> jComboBoxQueries = new JComboBox();
	DefaultComboBoxModel<Question> modelQueries =  new DefaultComboBoxModel<Question>();
	
	private JComboBox<Result> jComboBoxResults = new JComboBox<Result>();
	DefaultComboBoxModel<Result> modelResults = new DefaultComboBoxModel<Result>();

	private JLabel jLabelListOfEvents = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("ListEvents"));
	private JLabel jLabelEventDate = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("EventDate"));
	private JScrollPane scrollPaneQueries = new JScrollPane();
	private JCalendar jCalendar = new JCalendar();
	private Calendar calendarAct = null;
	private Calendar calendarAnt = null;

	private JScrollPane scrollPaneEvents = new JScrollPane();
	private JButton jButtonClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));
	private JLabel jLabelMsg = new JLabel();
	
	private Vector<Date> datesWithEventsCurrentMonth = new Vector<Date>();
	private final JLabel lblNewLabel_1 = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("MoneyBet")); //$NON-NLS-1$ //$NON-NLS-2$
	private JTextField moneyBet;
	String unekoUsername = null;
	
	private DefaultListModel<PartialBet> betModel = new DefaultListModel<PartialBet>();
	private JList<PartialBet> betList = new JList<PartialBet>();
	private JScrollPane betScrollPane = new JScrollPane();
	private ArrayList<PartialBet> arrPartialBet = new ArrayList<PartialBet>();
	
	public MultipleBetGUI(Vector<domain.Event> v, String username) {
		unekoUsername = username;
		try {
			jbInit(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit(Vector<domain.Event> v) throws Exception {
		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(604, 370));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
		jComboBoxEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelQueries.removeAllElements();
				if(jComboBoxEvents.isFocusOwner()) {
				Event ev = (Event) jComboBoxEvents.getSelectedItem();
				for(Question q: ev.getQuestions()) {
					modelQueries.addElement(q);
				}
			}
			}
		});
		
		betScrollPane.setBounds(new Rectangle(274, 217, 263, 58));
		getContentPane().add(betScrollPane);
		betScrollPane.setViewportView(betList);
		betList.setModel(betModel);
		
		jComboBoxEvents.setModel(modelEvents);
		jComboBoxEvents.setBounds(new Rectangle(275, 49, 250, 20));
		jComboBoxQueries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelResults.removeAllElements();
				if(jComboBoxQueries.isFocusOwner()) {
					Question qu = (Question) jComboBoxQueries.getSelectedItem();
					for(Result r: qu.getResults()) {
						modelResults.addElement(r);
					}
				}
			}
		});
		jComboBoxQueries.setModel(modelQueries);
		jComboBoxQueries.setBounds(new Rectangle(275, 105, 250, 20));
		jComboBoxResults.setModel(modelResults);
		jComboBoxResults.setBounds(new Rectangle(275, 161, 250, 20));
		jLabelListOfEvents.setBounds(new Rectangle(275, 18, 277, 20));

		jCalendar.setBounds(new Rectangle(40, 50, 225, 150));
		scrollPaneEvents.setBounds(new Rectangle(25, 44, 346, 116));

		jButtonClose.setBounds(new Rectangle(482, 18, 96, 20));
		jButtonClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonClose_actionPerformed(e);
			}
		});

		jLabelMsg.setBounds(new Rectangle(275, 161, 305, 20));
		jLabelMsg.setForeground(Color.red);

		this.getContentPane().add(jLabelMsg, null);

		this.getContentPane().add(jButtonClose, null);

		this.getContentPane().add(jLabelListOfEvents, null);
		this.getContentPane().add(jComboBoxEvents, null);
		this.getContentPane().add(jComboBoxQueries, null);
		this.getContentPane().add(jComboBoxResults, null);

		this.getContentPane().add(jCalendar, null);
		
		
		BLFacade facade = MainGUI.getBusinessLogic();
		datesWithEventsCurrentMonth=facade.getEventsMonth(jCalendar.getDate());
		paintDaysWithEvents(jCalendar,datesWithEventsCurrentMonth);
		
		

		jLabelEventDate.setBounds(new Rectangle(40, 15, 140, 25));
		jLabelEventDate.setBounds(40, 16, 140, 25);
		getContentPane().add(jLabelEventDate);
		
		JLabel lblNewLabel = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Queries")); //$NON-NLS-1$ //$NON-NLS-2$
		lblNewLabel.setBounds(275, 80, 96, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel results = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Result")); //$NON-NLS-1$ //$NON-NLS-2$
		results.setBounds(275, 136, 106, 14);
		getContentPane().add(results);
		lblNewLabel_1.setBounds(40, 219, 131, 14);
		
		getContentPane().add(lblNewLabel_1);
		
		moneyBet = new JTextField();
		moneyBet.setBounds(40, 244, 131, 20);
		getContentPane().add(moneyBet);
		moneyBet.setColumns(10);
		
		JButton bet = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Bet")); //$NON-NLS-1$ //$NON-NLS-2$
		bet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					BLFacade facade = MainGUI.getBusinessLogic();
					String operation = "Apustu anitza egin du: ";
					Float mbm = Float.parseFloat(moneyBet.getText());
					User u = facade.getUserByUsername(unekoUsername);
					if(u.getMoney() < mbm) {
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(bet, "Ez duzu diru kantitate hori");
					}else {
					MultipleBet multipleBet = new MultipleBet(mbm);
					for(PartialBet pb: arrPartialBet) {
						multipleBet.addBet(pb);
						operation = operation +" " + pb.getEvent().getDescription();
					}
					facade.createMultipleBet(multipleBet);
					facade.outputMoney(unekoUsername, mbm);
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(bet, "Apustu anitza gorde da");
					facade.addOperation(unekoUsername, operation);
					}
				}
		});
		bet.setBounds(40, 271, 131, 35);
		getContentPane().add(bet);
		
		JLabel lblNewLabel_2 = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Bets")); //$NON-NLS-1$ //$NON-NLS-2$
		lblNewLabel_2.setBounds(275, 192, 96, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Add")); //$NON-NLS-1$ //$NON-NLS-2$
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				Event ev = (Event) jComboBoxEvents.getSelectedItem();
				Question qu = (Question) jComboBoxQueries.getSelectedItem();
				Result re =  (Result)jComboBoxResults.getSelectedItem();
				User u = facade.getUserByUsername(unekoUsername);
					PartialBet pb = new PartialBet(ev, qu, re, u);
					facade.createPartialBet(pb);
					betModel.addElement(pb);
					arrPartialBet.add(pb);
			}
		});
		btnNewButton.setBounds(361, 286, 89, 23);
		getContentPane().add(btnNewButton);

		
		// Code for JCalendar
		
		this.jCalendar.addPropertyChangeListener(new PropertyChangeListener() {
			
			public void propertyChange(PropertyChangeEvent propertychangeevent) {
//				this.jCalendar.addPropertyChangeListener(new PropertyChangeListener() {
//					public void propertyChange(PropertyChangeEvent propertychangeevent) {
				if (propertychangeevent.getPropertyName().equals("locale")) {
					jCalendar.setLocale((Locale) propertychangeevent.getNewValue());
				} else if (propertychangeevent.getPropertyName().equals("calendar")) {
					calendarAnt = (Calendar) propertychangeevent.getOldValue();
					calendarAct = (Calendar) propertychangeevent.getNewValue();
					System.out.println("calendarAnt: "+calendarAnt.getTime());
					System.out.println("calendarAct: "+calendarAct.getTime());
					DateFormat dateformat1 = DateFormat.getDateInstance(1, jCalendar.getLocale());
					
					int monthAnt = calendarAnt.get(Calendar.MONTH);
					int monthAct = calendarAct.get(Calendar.MONTH);
					if (monthAct!=monthAnt) {
						if (monthAct==monthAnt+2) { 
							// Si en JCalendar estÃ¡ 30 de enero y se avanza al mes siguiente, devolverÃ­a 2 de marzo (se toma como equivalente a 30 de febrero)
							// Con este cÃ³digo se dejarÃ¡ como 1 de febrero en el JCalendar
							calendarAct.set(Calendar.MONTH, monthAnt+1);
							calendarAct.set(Calendar.DAY_OF_MONTH, 1);
						}
						
						jCalendar.setCalendar(calendarAct);
						
						BLFacade facade = MainGUI.getBusinessLogic();

						datesWithEventsCurrentMonth=facade.getEventsMonth(jCalendar.getDate());
					}



					paintDaysWithEvents(jCalendar,datesWithEventsCurrentMonth);

					//	Date firstDay = UtilDate.trim(new Date(jCalendar.getCalendar().getTime().getTime()));
					Date firstDay = UtilDate.trim(calendarAct.getTime());

					try {
						BLFacade facade = MainGUI.getBusinessLogic();

						Vector<domain.Event> events = facade.getEvents(firstDay);

						if (events.isEmpty())
							jLabelListOfEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("NoEvents")
									+ ": " + dateformat1.format(calendarAct.getTime()));
						else
							jLabelListOfEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("Events") + ": "
									+ dateformat1.format(calendarAct.getTime()));
						jComboBoxEvents.removeAllItems();
						System.out.println("Events " + events);

						for (domain.Event ev : events)
							modelEvents.addElement(ev);
						jComboBoxEvents.repaint();

					} catch (Exception e1) {
					}

				}
			}
		});
	}

	
public static void paintDaysWithEvents(JCalendar jCalendar,Vector<Date> datesWithEventsCurrentMonth) {
		// For each day with events in current month, the background color for that day is changed.

		
		Calendar calendar = jCalendar.getCalendar();
		
		int month = calendar.get(Calendar.MONTH);
		int today=calendar.get(Calendar.DAY_OF_MONTH);
		int year=calendar.get(Calendar.YEAR);
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int offset = calendar.get(Calendar.DAY_OF_WEEK);

		if (Locale.getDefault().equals(new Locale("es")))
			offset += 4;
		else
			offset += 5;
		
		
	 	for (Date d:datesWithEventsCurrentMonth){

	 		calendar.setTime(d);
	 		System.out.println(d);
	 		

			
			// Obtain the component of the day in the panel of the DayChooser of the
			// JCalendar.
			// The component is located after the decorator buttons of "Sun", "Mon",... or
			// "Lun", "Mar"...,
			// the empty days before day 1 of month, and all the days previous to each day.
			// That number of components is calculated with "offset" and is different in
			// English and Spanish
//			    		  Component o=(Component) jCalendar.getDayChooser().getDayPanel().getComponent(i+offset);; 
			Component o = (Component) jCalendar.getDayChooser().getDayPanel()
					.getComponent(calendar.get(Calendar.DAY_OF_MONTH) + offset);
			o.setBackground(Color.CYAN);
	 	}
	 	
 			calendar.set(Calendar.DAY_OF_MONTH, today);
	 		calendar.set(Calendar.MONTH, month);
	 		calendar.set(Calendar.YEAR, year);

	 	
	}
	private void jButtonClose_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}