import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class OperatiiBD {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void insert(String numarInmatriculare, String marca, int an, String culoare, int numarKm) {
        String SQL = "insert into masini (numarInmatriculare, marca, an, culoare, numarKm) values (?,?,?,?,?)";
        jdbcTemplateObject.update(SQL, numarInmatriculare, marca, an, culoare, numarKm);
    }

    public void delete(String numarInmatriculare) {
        String SQL = "delete from masini where numarInmatriculare = ?";
        jdbcTemplateObject.update(SQL, numarInmatriculare);
    }

    public void searchCar(String numarInmatriculare) {
        String SQL = "select * from masini where numarInmatriculare = ?";
        Masina masina = jdbcTemplateObject.queryForObject(SQL,new Object[] {numarInmatriculare}, new MasinaMapper());
        System.out.println(masina.toString());
    }

    public List<Masina> getListaMasini(){
        String SQL = "select * from masini";
        List<Masina> masini = jdbcTemplateObject.query(SQL,new MasinaMapper());
        return masini;
    }

    public void getNumberOfCars(String marca) {
        String SQL = "select * from masini where marca = ?";
        int count = jdbcTemplateObject.query(SQL,new Object[] {marca}, new MasinaMapper()).size();
        System.out.println("Numar de masini cu marca " + marca + ":" + count);
    }

    public int getNumberOfCarsWithKM(int numarKm){
        String SQL = "select * from masini where numarKm < ?";
        int count = jdbcTemplateObject.query(SQL,new Object[] {numarKm}, new MasinaMapper()).size();
        return count;
    }

    public List<Masina> getCarsByYear(int year){
        String SQL = "select * from masini where an > ?";
        List<Masina> masini = jdbcTemplateObject.query(SQL,new Object[] {year}, new MasinaMapper());
        return masini;
    }
}
