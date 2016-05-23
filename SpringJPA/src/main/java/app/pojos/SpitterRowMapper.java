package app.pojos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpitterRowMapper<T> implements RowMapper<Spitter> {

	@Override
	public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Spitter(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"),
				rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getDate("registerDate"));
	}

}
