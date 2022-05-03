package domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	private String name;
	@Id
	private String username;
	private String email;
	private String password;
	private String birthday;
	private double money;
	private ArrayList<String> operations;
	private ArrayList<Txat> txats;
	
	public User(String n, String u, String e, String p, String day, String month, String year) {
		this.name = n;
		this.username = u;
		this.email = e;
		this.password = p;
		this.birthday = day+"/"+month+"/"+year;
		this.money = 0.0;
		operations = new ArrayList<String>();
		txats = new ArrayList<Txat>();
	}

	public ArrayList<Txat> getTxats() {
		return txats;
	}

	public void setTxats(ArrayList<Txat> txats) {
		this.txats = txats;
	}

	public ArrayList<String> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<String> operations) {
		this.operations = operations;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String day, String month, String year) {
		this.birthday = day+"/"+month+"/"+year;
	}
	
	public void addMoney(double m) {
		this.money = money + m;
	}
	
	public void substractMoney(double m) {
		this.money = money - m;
	}
	
	public void addOperation(String s) {
		this.operations.add(s);
	}
	
	public void addTxat(Txat t) {
		this.txats.add(t);
	}
}
