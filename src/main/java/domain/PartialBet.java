package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PartialBet {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer partialBetNumber;
	private Event event;
	private Question question;
	private Result result;
	private User user;
	private boolean amaituta;
	private boolean irabazita;
	
	public PartialBet(Event e, Question q, Result r, User u) {
		this.event = e;
		this.question = q;
		this.result = r;
		this.user = u;
		this.amaituta = false;
		this.irabazita = false;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAmaituta() {
		return amaituta;
	}

	public void setAmaituta(boolean amaituta) {
		this.amaituta = amaituta;
	}

	public boolean isIrabazita() {
		return irabazita;
	}

	public void setIrabazita(boolean irabazita) {
		this.irabazita = irabazita;
	}

	public Integer getPartialBetNumber() {
		return partialBetNumber;
	}
	
	public String toString() {
		return event.getDescription()+"-"+question.getQuestion()+"-"+result.getResult();
	}
}
