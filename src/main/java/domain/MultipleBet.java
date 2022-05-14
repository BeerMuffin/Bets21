package domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MultipleBet {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer multipleBetNumber;
	private ArrayList<PartialBet> bets;
	private Float multipleBetMoney;
	private boolean amaituta;
	private boolean irabazita;
	
	public MultipleBet(Float mbm) {
		bets = new ArrayList<PartialBet>();
		this.multipleBetMoney = mbm;
		this.amaituta = false;
		this.irabazita = false;
	}

	public Float getMultipleBetMoney() {
		return multipleBetMoney;
	}

	public void setMultipleBetMoney(Float multipleBetMoney) {
		this.multipleBetMoney = multipleBetMoney;
	}

	public void addBet(PartialBet b) {
		bets.add(b);
	}
	
	public Integer getMultipleBetNumber() {
		return multipleBetNumber;
	}

	public void setMultipleBetNumber(Integer multipleBetNumber) {
		this.multipleBetNumber = multipleBetNumber;
	}

	public ArrayList<PartialBet> getBets() {
		return bets;
	}

	public void setBets(ArrayList<PartialBet> bets) {
		this.bets = bets;
	}

	public boolean isAmaituta() {
		return amaituta;
	}
	
	public void setAmaituta() {
		if(this.allAmaitutak()) {
			this.amaituta = true;
		}
	}

	public boolean isIrabazita() {
		return irabazita;
	}
	
	public void setIrabazita() {
		if(this.allIrabazitak()) {
			this.irabazita = true;
		}
	}

	public boolean allAmaitutak() {
		int kont=0;
		for(PartialBet b: bets) {
			if(b.isAmaituta())
			kont+=1;
		}
		if(kont == bets.size()) {
			return true;
		}
		else
			return false;
	}
	
	public boolean allIrabazitak() {
		int kont=0;
		for(PartialBet b: bets) {
			if(b.isIrabazita())
			kont+=1;
		}
		if(kont == bets.size()) {
			return true;
		}
		else
			return false;
	}
	
	public ArrayList<PartialBet> getEzAmaitutak(){
		ArrayList<PartialBet> arr = new ArrayList<PartialBet>();
		for(PartialBet pb: this.bets) {
			if(!pb.isAmaituta()) {
				arr.add(pb);
			}
		}
		return arr;
	}
	
	public User getUser() {
		User u = null;
		for(int i=0; i < 1; i++) {
			u = bets.get(0).getUser();
		}
		return u;
	}
	
	public double kuotaTotala() {
		double kuota = 1.0;
		for(PartialBet pb: this.bets) {
			kuota = kuota * pb.getResult().getOdd();
		}
		return kuota;
	}
}
