package exemplu7;

public class Persoana {
	private String nume;
	private int varsta;
	private Adresa adresa;
	
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
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	
	public String toString() {
		return nume + ", " + varsta + ", " + adresa.toString();
	}
}
