package exemplu8;

import java.util.Set;

public class Persoana {
	private String nume;
	private int varsta;
	private Set<Adresa> adrese;
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	public Set<Adresa> getAdrese() {
		return adrese;
	}
	public void setAdrese(Set<Adresa> adrese) {
		this.adrese = adrese;
	}
	
}
