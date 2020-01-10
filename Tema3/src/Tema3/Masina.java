package Tema3;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "masina")
public class Masina {
	@Id
	@Column (name="nr_inmatriculare")
	private String nr_inmatriculare;
	
	@Column (name="id_utilizator")
	private int id_utilizator;
	
	@Column (name="marca")
	private String marca;
	
	@Column (name="modelul")
	private String modelul;
	
	@Column (name="culoarea")
	private String culoarea;
	
	@Column (name="anul_fabricatiei")
	private int anul_fabricatiei;
	
	@Column (name="capacitatea_cilindrica")
	private int capacitatea_cilindrica;
	
	@Column (name="tipul_de_combustibil")
	private String tipul_de_combustibil;
	
	@Column (name="puterea")
	private int puterea;
	
	@Column (name="cuplul")
	private int cuplul;	
	
	@Column (name="volumul_portbagajului")
	private int volumul_portbagajului;
	
	@Column (name="pret")
	private Float pret;

	public Masina() {}

	public Masina(String nr_inmatriculare, int id_utilizator, String marca, String modelul, String culoarea, int anul_fabricatiei,
			int capacitatea_cilindrica, String tipul_de_combustibil, int puterea, int cuplul, int volumul_portbagajului, Float pret) {
		this.nr_inmatriculare = nr_inmatriculare;
		this.id_utilizator = id_utilizator;
		this.marca = marca;
		this.modelul = modelul;
		this.culoarea = culoarea;
		this.anul_fabricatiei = anul_fabricatiei;
		this.capacitatea_cilindrica = capacitatea_cilindrica;
		this.tipul_de_combustibil = tipul_de_combustibil;
		this.puterea = puterea;
		this.cuplul = cuplul;
		this.volumul_portbagajului = volumul_portbagajului;
		this.pret = pret;
	}

	public String getNr_inmatriculare() {
		return nr_inmatriculare;
	}

	public void setNr_inmatriculare(String nr_inmatriculare) {
		this.nr_inmatriculare = nr_inmatriculare;
	}

	public int getId_utilizator() {
		return id_utilizator;
	}

	public void setId_utilizator(int id_utilizator) {
		this.id_utilizator = id_utilizator;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelul() {
		return modelul;
	}

	public void setModelul(String modelul) {
		this.modelul = modelul;
	}

	public String getCuloarea() {
		return culoarea;
	}

	public void setCuloarea(String culoarea) {
		this.culoarea = culoarea;
	}

	public int getAnul_fabricatiei() {
		return anul_fabricatiei;
	}

	public void setAnul_fabricatiei(int anul_fabricatiei) {
		this.anul_fabricatiei = anul_fabricatiei;
	}

	public int getCapacitatea_cilindrica() {
		return capacitatea_cilindrica;
	}

	public void setCapacitatea_cilindrica(int capacitatea_cilindrica) {
		this.capacitatea_cilindrica = capacitatea_cilindrica;
	}

	public String getTipul_de_combustibil() {
		return tipul_de_combustibil;
	}

	public void setTipul_de_combustibil(String tipul_de_combustibil) {
		this.tipul_de_combustibil = tipul_de_combustibil;
	}

	public int getPuterea() {
		return puterea;
	}

	public void setPuterea(int puterea) {
		this.puterea = puterea;
	}

	public int getCuplul() {
		return cuplul;
	}

	public void setCuplul(int cuplul) {
		this.cuplul = cuplul;
	}

	public int getVolumul_portbagajului() {
		return volumul_portbagajului;
	}

	public void setVolumul_portbagajului(int volumul_portbagajului) {
		this.volumul_portbagajului = volumul_portbagajului;
	}

	public Float getPret() {
		return pret;
	}

	public void setPret(Float pret) {
		this.pret = pret;
	}

	@Override
	public String toString() {
		return "Masina cu datele: nr_inmatriculare=" + nr_inmatriculare + ", id_utilizator=" + id_utilizator + ", marca=" + marca
				+ ", modelul=" + modelul + ", culoarea=" + culoarea + ", anul_fabricatiei=" + anul_fabricatiei
				+ ", capacitatea_cilindrica=" + capacitatea_cilindrica + ", tipul_de_combustibil=" + tipul_de_combustibil
				+ ", puterea=" + puterea + ", cuplul=" + cuplul + ", volumul_portbagajului=" + volumul_portbagajului + ", pret="+ pret;
	}
}
