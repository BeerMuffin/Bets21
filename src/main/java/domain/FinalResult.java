package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FinalResult {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer frnumber;
	private Event event;
	private Question question;
	private String finalResult;
	
	public FinalResult(Event ev, Question qu, String fr) {
		this.event = ev;
		this.question = qu;
		this.finalResult = fr;
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

	public String getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(String finalResult) {
		this.finalResult = finalResult;
	}
	
	
}
