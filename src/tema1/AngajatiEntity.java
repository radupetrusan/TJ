package tema1;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "angajati", schema = "tema1", catalog = "")
public class AngajatiEntity {
    private int id;
    private String nume;
    private String firma;
    private String functia;
    private Timestamp dataAngajarii;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nume")
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Basic
    @Column(name = "firma")
    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Basic
    @Column(name = "functia")
    public String getFunctia() {
        return functia;
    }

    public void setFunctia(String functia) {
        this.functia = functia;
    }

    @Basic
    @Column(name = "data_angajarii")
    public Timestamp getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(Timestamp dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AngajatiEntity that = (AngajatiEntity) o;
        return id == that.id &&
                Objects.equals(nume, that.nume) &&
                Objects.equals(firma, that.firma) &&
                Objects.equals(functia, that.functia) &&
                Objects.equals(dataAngajarii, that.dataAngajarii);
    }

    @Override
    public String toString() {
        return this.getNume() + ", " + this.getFunctia() + " la " + this.getFirma() + " din data de " + this.getDataAngajarii().toString() + " (id " + this.getId() + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, firma, functia, dataAngajarii);
    }
}
