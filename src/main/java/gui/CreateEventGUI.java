package gui;

/**
 * @author Software Engineering teachers
 */


import javax.swing.*;


import businessLogic.BLFacade;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class CreateEventGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;


    private static BLFacade appFacadeInterface;
	
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	 
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}
	protected JLabel jLabelSelectOption;
	
	
	/**
	 * This is the default constructor
	 */
	public CreateEventGUI() {
		super();
		
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
		this.setTitle("CreateEvent");
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
			
		}
		return jContentPane;
	}


	
} // @jve:decl-index=0:visual-constraint="0,0"



