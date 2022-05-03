package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Txat {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private User user1;
	private User user2;
	private ArrayList<String> mezuak = new ArrayList<String>();
	
	public Txat(User us1, User us2) {
		super();
		this.user1 = us1;
		this.user2 = us2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public ArrayList<String> getMezuak() {
		return mezuak;
	}

	public void setMezuak(ArrayList<String> mezuak) {
		this.mezuak = mezuak;
	}
	
	public void addMezua(String tm)  {
		this.mezuak.add(tm);
	}
	
	public String toString() {
		return this.user2.getUsername();
	}
}
