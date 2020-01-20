package exemplu8;

public class Adresa {
	private int nr;
	private String strada;
	private String localitatea;
	
	public Adresa(int nr, String strada, String localitatea) {
		this.nr = nr;
		this.strada = strada;
		this.localitatea = localitatea;
	}
	
	public String toString() {
		return nr + ", " + strada + ", " + localitatea;
	}
}
