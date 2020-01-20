import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Autoturism extends Vehicul {
    private String marca;
    private int anFabricatie;

    public Autoturism() {}
    public Autoturism(int pret, int viteza_max, String marca, int anFabricatie) {
        super(pret, viteza_max);
        this.marca = marca;
        this.anFabricatie = anFabricatie;
    }
    public String getMarca() {
        return this.marca;
    }

    @Autowired(required=false)
    @Value("Mercedes")
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getAnul() {
        return this.anFabricatie;
    }

    @Value("2014")
    public void setAnul(int anul) {
        this.anFabricatie = anul;
    }

    @Override
    public String toString() {
        return getPret() + ", " + getVitezaMaxima() + ", " + this.marca + ", " + this.anFabricatie;
    }
}
