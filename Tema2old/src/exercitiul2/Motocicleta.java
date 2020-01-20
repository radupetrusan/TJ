package exercitiul2;

public class Motocicleta extends Vehicul {
	private String tipul;
	
	public Motocicleta() {}
	public Motocicleta(int pret, int viteza_max, String tipul) {
		super(pret,viteza_max);
		this.tipul = tipul;
	}
	
	public String getTipul() {
		return tipul;
	}
	public void setTipul(String tipul) {
		this.tipul = tipul;
	}
	
	public String toString() {
		return getPret() + ", " + getViteza_max() + ", " + tipul;
	}
	
}
