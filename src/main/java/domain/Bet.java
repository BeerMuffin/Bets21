package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Bet {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer betNumber;
	private Event event;
	private Question question;
	private Result result;
	private Float betMoney;
	private User user;
	public Bet(Event e, Question q, Result r, Float bm, User u) {
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

	public Integer getBetNumber() {
		return betNumber;
	}

	public void setBetNumber(Integer betNumber) {
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
