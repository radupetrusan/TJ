package exercitiul2;

import org.springframework.beans.factory.annotation.Autowired;

public class Autoturism extends Vehicul{
	private String marca;
	private int anul;
	
	public Autoturism() {}
	public Autoturism(int pret, int viteza_max, String marca, int anul) {
		super(pret, viteza_max);
		this.marca = marca;
		this.anul = anul;
	}
	public String getMarca() {
		return marca;
	}
	@Autowired(required=false)
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAnul() {
		return anul;
	}
	public void setAnul(int anul) {
		this.anul = anul;
	}
	
	public String toString() {
		return getPret() + ", " + getViteza_max() + ", " + marca + ", " + anul;
	}
}
