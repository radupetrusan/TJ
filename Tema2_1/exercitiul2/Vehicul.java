package exercitiul2;

public class Vehicul {
	private int pret;
	private int viteza_max;
	
	public Vehicul() {}
	
	public Vehicul(int pret, int viteza_max){
		this.pret = pret;
		this.viteza_max = viteza_max;
	}
	
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public int getViteza_max() {
		return viteza_max;
	}
	public void setViteza_max(int viteza_max) {
		this.viteza_max = viteza_max;
	}
	
	public String toString() {
		return pret + ", " + viteza_max;
	}
}
