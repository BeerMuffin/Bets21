package businessLogic;
import java.util.ArrayList;
//hola
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.jws.WebMethod;
import javax.jws.WebService;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Question;
import domain.Result;
import domain.Txat;
import domain.User;
import domain.Admin;
import domain.Bet;
import domain.Event;
import domain.FinalResult;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

/**
 * It implements the business logic as a web service.
 */
@WebService(endpointInterface = "businessLogic.BLFacade")
public class BLFacadeImplementation  implements BLFacade {
	DataAccess dbManager;

	public BLFacadeImplementation()  {		
		System.out.println("Creating BLFacadeImplementation instance");
		ConfigXML c=ConfigXML.getInstance();
		
		if (c.getDataBaseOpenMode().equals("initialize")) {
		    dbManager=new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
		    dbManager.initializeDB();
		    } else
		     dbManager=new DataAccess();
		dbManager.close();

		
	}
	
    public BLFacadeImplementation(DataAccess da)  {
		
		System.out.println("Creating BLFacadeImplementation instance with DataAccess parameter");
		ConfigXML c=ConfigXML.getInstance();
		
		if (c.getDataBaseOpenMode().equals("initialize")) {
			da.open(true);
			da.initializeDB();
			da.close();

		}
		dbManager=da;		
	}
	

	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws EventFinished if current data is after data of the event
 	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
   @WebMethod
   public Question createQuestion(Event event, String question, float betMinimum) throws EventFinished, QuestionAlreadyExist{
	   
	    //The minimum bed must be greater than 0
		dbManager.open(false);
		Question qry=null;
		
	    
		if(new Date().compareTo(event.getEventDate())>0)
			throw new EventFinished(ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished"));
				
		
		 qry=dbManager.createQuestion(event,question,betMinimum);		

		dbManager.close();
		
		return qry;
   };
   
   public boolean createResult(Question question, String result, float odd) {
	   dbManager.open(false);
	   boolean r = dbManager.createResult(question, result, odd);
	   dbManager.close();
	   return r;
   }
   
   public boolean createBet(Bet b) {
	   dbManager.open(false);
	   boolean r = dbManager.createBet(b);
	   dbManager.close();
	   return r;
   }
   
   public boolean registerUser(User u) {
	   dbManager.open(false);
	   boolean reg;
	   reg = dbManager.registerUser(u);
	   dbManager.close();
	   return reg;
   }
   
   public boolean registerAdmin(Admin a) {
	   dbManager.open(false);
	   boolean reg;
	   reg = dbManager.registerAdmin(a);
	   dbManager.close();
	   return reg;
   }
   
   public boolean createEvent(Event e) {
	   dbManager.open(false);
	   boolean cr = dbManager.createEvent(e);
	   dbManager.close();
	   return cr;
   }
   
   public User getUserByUsername(String username) {
	   dbManager.open(false);
	   User u = dbManager.getUserByUsername(username);
	   dbManager.close();
	   return u;
   }
   
   public Admin getAdminByUsername(String username) {
	   dbManager.open(false);
	   Admin a = dbManager.getAdminByUsername(username);
	   dbManager.close();
	   return a;
   }
   
   public void inputMoney(String u, double money) {
	   dbManager.open(false);
	   dbManager.inputMoney(u, money);
	   dbManager.close();
   }
   
   public void outputMoney(String u, double money) {
	   dbManager.open(false);
	   dbManager.outputMoney(u, money);
	   dbManager.close();
   }
	
	/**
	 * This method invokes the data access to retrieve the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
    @WebMethod	
	public Vector<Event> getEvents(Date date)  {
		dbManager.open(false);
		Vector<Event>  events=dbManager.getEvents(date);
		dbManager.close();
		return events;
	}

    
	/**
	 * This method invokes the data access to retrieve the dates a month for which there are events
	 * 
	 * @param date of the month for which days with events want to be retrieved 
	 * @return collection of dates
	 */
	@WebMethod public Vector<Date> getEventsMonth(Date date) {
		dbManager.open(false);
		Vector<Date>  dates=dbManager.getEventsMonth(date);
		dbManager.close();
		return dates;
	}
	
	
	public void close() {
		DataAccess dB4oManager=new DataAccess(false);

		dB4oManager.close();

	}

	/**
	 * This method invokes the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
    @WebMethod	
	 public void initializeBD(){
    	dbManager.open(false);
		dbManager.initializeDB();
		dbManager.close();
	}

    public Result getResultByResult(String result) {
    	dbManager.open(false);
    	Result res = dbManager.getResultByResult(result);
    	dbManager.close();
    	return res;
    }
    
    public void addOperation(String u, String o) {
    	dbManager.open(false);
    	dbManager.addOperation(u, o);
    	dbManager.close();
    }
    
    public ArrayList<String> getOperationsDB(String u){
    	dbManager.open(false);
    	ArrayList<String> ar = dbManager.getOperationsDB(u);
    	dbManager.close();
    	return ar;
    }
    
    public void putResults(FinalResult fr) {
    	dbManager.open(false);
    	dbManager.putResults(fr);
    	dbManager.close();
    }

	@Override
	public void createTxat(Txat t) {
		dbManager.open(false);
		dbManager.createTxat(t);
		dbManager.close();
		
	}

	@Override
	public void addTxat(String u, Txat t) {
		dbManager.open(false);
		dbManager.addTxat(u, t);
		dbManager.close();
	}

	@Override
	public ArrayList<Txat> getTxatsDB(String u) {
		dbManager.open(false);
    	ArrayList<Txat> ar = dbManager.getTxatsDB(u);
    	dbManager.close();
    	return ar;
	}
	
	@Override
	public ArrayList<String> getTxatMezuakDB(Txat t){
		dbManager.open(false);
		ArrayList<String> ar = dbManager.getTxatMezuakDB(t);
		dbManager.close();
		return ar;
	}
	
	@Override
	public void addMezua(String tm, Txat txat) {
		dbManager.open(false);
		dbManager.addMezua(tm, txat);
		dbManager.close();
	}
}

