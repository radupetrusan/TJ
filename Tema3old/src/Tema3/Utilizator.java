package Tema3;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilizatori")
public class Utilizator {
	@Id @GeneratedValue
	@Column (name="id_utilizator")
	private int id_utilizator;

	@Column (name="nume")
	private String nume;

	@Column (name="utilizator")	
	private String utilizator;

	@Column (name="parola")
	private String parola;

	@Column (name="nivel_acces")
	private int nivel_acces;

	public Utilizator() {}

	public Utilizator(int id_utilizator, String nume, String utilizator, String parola, int nivel_acces) {
		this.id_utilizator = id_utilizator;
		this.nume = nume;
		this.utilizator = utilizator;
		this.parola = parola;
		this.nivel_acces = nivel_acces;
	}

	public int getId_utilizator() {
		return id_utilizator;
	}

	public void setId_utilizator(int id_utilizator) {
		this.id_utilizator = id_utilizator;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getUtilizator() {
		return utilizator;
	}

	public void setUtilizator(String utilizator) {
		this.utilizator = utilizator;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public int getNivel_acces() {
		return nivel_acces;
	}

	public void setNivel_acces(int nivel_acces) {
		this.nivel_acces = nivel_acces;
	}

	@Override
	public String toString() {
		return "Utilizator cu datele: id_utilizator=" + id_utilizator + ", nume=" + nume + ", utilizator=" + utilizator 
				+ ", parola=" + parola + ", nivel_acces=" + nivel_acces;
	}
}
