public class Masina {
    private int id;
    private String numarInmatriculare;
    private String marca;
    private int an;
    private String culoare;
    private int numarKm;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }
    public void setNumarInmatriculare(String numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public int getAn() {
        return this.an;
    }
    public void setAn(int an) {
        this.an = an;
    }

    public String getCuloare() {
        return culoare;
    }
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getNumarKm() {
        return this.numarKm;
    }
    public void setNumarKm(int numarKm) {
        this.numarKm = numarKm;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String toString() {
        return id + ". " + marca + ", " + numarInmatriculare + ", " + an + ", " + culoare + ", " + numarKm + "km";
    }
}
