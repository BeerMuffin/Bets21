package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer resultId;
	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	private String result;
	private Float odd;
	
	public Result(String result, Float odd) {
		this.result = result;
		this.odd = odd;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Float getOdd() {
		return odd;
	}

	public void setOdd(Float odd) {
		this.odd = odd;
	}
	
	public String toString() {
		return this.result +"; "+ this.odd;
	}
}
