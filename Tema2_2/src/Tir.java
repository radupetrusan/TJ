public class Tir extends Vehicul{

    private int incarcaturaMaxima;

    public Tir() {}
    public Tir(int pret, int viteza_max, int incarcatura_max) {
        super(pret, viteza_max);
        this.incarcaturaMaxima = incarcatura_max;
    }
    public int getIncarcaturaMaxima() {
        return this.incarcaturaMaxima;
    }
    //    @Required
    public void setIncarcaturaMaxima(int incarcaturaMaxima) {
        this.incarcaturaMaxima = incarcaturaMaxima;
    }

    @Override
    public String toString() {
        return getPret() + ", " + getVitezaMaxima() + ", " + this.incarcaturaMaxima;
    }
}