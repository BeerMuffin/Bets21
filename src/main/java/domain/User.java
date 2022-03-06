package domain;

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
	
	public User(String n, String u, String e, String p, String day, String month, String year) {
		this.name = n;
		this.username = u;
		this.email = e;
		this.password = p;
		this.birthday = day+"/"+month+"/"+year;
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
	
}
