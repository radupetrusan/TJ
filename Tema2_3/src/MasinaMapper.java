import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MasinaMapper implements RowMapper<Masina> {
    public Masina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Masina masina = new Masina();
        masina.setId(rs.getInt("id"));
        masina.setNumarInmatriculare(rs.getString("numarInmatriculare"));
        masina.setMarca(rs.getString("marca"));
        masina.setAn(rs.getInt("an"));
        masina.setCuloare(rs.getString("culoare"));
        masina.setNumarKm(rs.getInt("numarKm"));

        return masina;
    }
}
