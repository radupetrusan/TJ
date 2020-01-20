package exercitiul3;

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
	
	public void insert(String nr_inmatriculare, String marca, int anul, String culoare, int nr_km) {
		String SQL = "insert into masini (nr_inmatriculare, marca, anul, culoare, nr_km) values (?,?,?,?,?)";
		jdbcTemplateObject.update(SQL, nr_inmatriculare,marca,anul,culoare,nr_km);
	}
	
	public void delete(String nr_inmatriculare) {
		String SQL = "delete from masini where nr_inmatriculare = ?";
		jdbcTemplateObject.update(SQL, nr_inmatriculare);
	}
	
	public void searchCar(String nr_inmatriculare) {
		String SQL = "select * from masini where nr_inmatriculare = ?";
		Masina masina = jdbcTemplateObject.queryForObject(SQL,new Object[] {nr_inmatriculare}, new MasinaMapper());
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
	
	public List<Masina> getCarsWithKM(int nr_km){
		String SQL = "select * from masini where nr_km < ?";
		List<Masina> masini = jdbcTemplateObject.query(SQL,new Object[] {nr_km}, new MasinaMapper());
		return masini;
	}
	
	public List<Masina> getCarsByYear(int year){
		String SQL = "select * from masini where anul > ?";
		List<Masina> masini = jdbcTemplateObject.query(SQL,new Object[] {year}, new MasinaMapper());
		return masini;
	}
}
