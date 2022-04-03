package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Bet {

	@Id
	private String betNumber;
	private Event event;
	private Question question;
	private Result result;
	private Float betMoney;
	private User user;
	public Bet(String bn, Event e, Question q, Result r, Float bm, User u) {
		this.betNumber = bn;
		this.event = e;
		this.question = q;
		this.result = r;
		this.betMoney = bm;
		this.user = u;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBetNumber() {
		return betNumber;
	}

	public void setBetNumber(String betNumber) {
		this.betNumber = betNumber;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Float getBetMoney() {
		return betMoney;
	}

	public void setBetMoney(Float betMoney) {
		this.betMoney = betMoney;
	}
	
	
}
