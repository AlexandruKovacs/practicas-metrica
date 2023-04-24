package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBBDDMejor {

	private static AccesoBBDDMejor instancia;
	private Connection conex;
	
	private AccesoBBDDMejor() {
		try {
			conex =  DriverManager.getConnection("jdbc::mysql111.111.1.1:misDatos:admin:admin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static AccesoBBDDMejor get() {
		if(instancia == null) {
			instancia = new AccesoBBDDMejor();
		}
		
		return instancia;
	}
	
	public Statement query() throws SQLException {
		return conex.createStatement();
	}
	
	public Statement query(String sql) throws SQLException {
		return conex.prepareStatement(sql);
	}
	
	public void close() throws SQLException {
		conex.close();
		conex = null;
	}
}
