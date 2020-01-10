package exercitiul2;

import org.springframework.beans.factory.annotation.Required;

public class Tir extends Vehicul{
	private int incarcatura_max;
	
	public Tir() {}
	public Tir(int pret, int viteza_max, int incarcatura_max) {
		super(pret, viteza_max);
		this.incarcatura_max = incarcatura_max;
	}
	public int getIncarcatura_max() {
		return incarcatura_max;
	}
	@Required
	public void setIncarcatura_max(int incarcatura_max) {
		this.incarcatura_max = incarcatura_max;
	}
	
	public String toString() {
		return getPret() + ", " + getViteza_max() + ", " + incarcatura_max;
	}
	
}
