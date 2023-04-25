package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.DAO;
import dao.DTO.Juego;
import singleton.AccesoBBDDMejor;

public class PersonaDAO implements DAO<Juego, String> {

	public Juego find(String key) throws SQLException {
		String sql = "SELECT * FROM juego WHERE nombre = ?";
		
		PreparedStatement st = (PreparedStatement) AccesoBBDDMejor.get().query(sql);
		st.setString(1, key);
		
		ResultSet result = st.executeQuery();
		
		if(!result.next()) {
			return null;
		}
		int generoID = result.getString("genero"); // FK
		String genero = new DAOGenero().find(generoID);
		
		return new Juego(
				result.getString("nombre"),
				result.getString("numJugadores"),
				genero
				);
	}

	public boolean insert(Juego value) throws SQLException {
		return false;
	}

	public Juego delete(String key) throws SQLException {
		return null;
	}

	public Juego update(Juego element) throws SQLException {
		return null;
	}

	public int deleteAll() throws SQLException {
		return 0;
	}

	public List<Juego> findAll() throws SQLException {
		return null;
	}

	public List<Juego> findBy(Map<String, String> condiciones) throws SQLException {
		return null;
	}

}
