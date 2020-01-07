package tema1;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cursuri", schema = "tema1", catalog = "")
public class CursuriEntity {
    private int idCurs;
    private String denumire;
    private Integer numarOre;
    private Integer valoare;
    private Integer diplomaAbsolvire;
    private Integer anul;

    @Id
    @Column(name = "id_curs")
    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    @Basic
    @Column(name = "denumire")
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Basic
    @Column(name = "numar_ore")
    public Integer getNumarOre() {
        return numarOre;
    }

    public void setNumarOre(Integer numarOre) {
        this.numarOre = numarOre;
    }

    @Basic
    @Column(name = "valoare")
    public Integer getValoare() {
        return valoare;
    }

    public void setValoare(Integer valoare) {
        this.valoare = valoare;
    }

    @Basic
    @Column(name = "diploma_absolvire")
    public Integer getDiplomaAbsolvire() {
        return diplomaAbsolvire;
    }

    public void setDiplomaAbsolvire(Integer diplomaAbsolvire) {
        this.diplomaAbsolvire = diplomaAbsolvire;
    }

    @Basic
    @Column(name = "anul")
    public Integer getAnul() {
        return anul;
    }

    public void setAnul(Integer anul) {
        this.anul = anul;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursuriEntity that = (CursuriEntity) o;
        return idCurs == that.idCurs &&
                Objects.equals(denumire, that.denumire) &&
                Objects.equals(numarOre, that.numarOre) &&
                Objects.equals(valoare, that.valoare) &&
                Objects.equals(diplomaAbsolvire, that.diplomaAbsolvire) &&
                Objects.equals(anul, that.anul);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurs, denumire, numarOre, valoare, diplomaAbsolvire, anul);
    }
}
