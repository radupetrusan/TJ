public class Vehicul {
    private int pret;
    private int vitezaMaxima;

    public Vehicul() {}

    public  Vehicul(int pret, int vitezaMaxima) {
        this.pret = pret;
        this.vitezaMaxima = vitezaMaxima;
    }

    public int getPret() {
        return this.pret;
    }

    public int getVitezaMaxima() {
        return this.vitezaMaxima;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public  void setVitezaMaxima(int vitezaMaxima) {
        this.vitezaMaxima = vitezaMaxima;
    }

    @Override
    public String toString() {
        return this.pret + ", " + this.vitezaMaxima;
    }
}
