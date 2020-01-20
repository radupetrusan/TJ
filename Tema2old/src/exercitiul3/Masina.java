package exercitiul3;

public class Masina {
	private int id;
	private String nr_inmatriculare;
	private String marca;
	private int anul;
	private String culoare;
	private int nr_km;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNr_inmatriculare() {
		return nr_inmatriculare;
	}
	public void setNr_inmatriculare(String nr_inmatriculare) {
		this.nr_inmatriculare = nr_inmatriculare;
	}
	
	public int getAnul() {
		return anul;
	}
	public void setAnul(int anul) {
		this.anul = anul;
	}
	
	public String getCuloare() {
		return culoare;
	}
	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}
	
	public int getNr_km() {
		return nr_km;
	}
	public void setNr_km(int nr_km) {
		this.nr_km = nr_km;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String toString() {
		return id + ", " + marca + ", " + nr_inmatriculare + ", " + anul + ", " + culoare + ", " + nr_km; 
	}
}
