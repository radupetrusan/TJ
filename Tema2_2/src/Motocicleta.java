public class Motocicleta extends Vehicul {
    private String tip;

    public Motocicleta() {}
    public Motocicleta(int pret, int vitezaMax, String tipul) {
        super(pret, vitezaMax);
        this.tip = tipul;
    }

    public String getTip() {
        return this.tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return getPret() + ", " + getVitezaMaxima() + ", " + tip;
    }
}