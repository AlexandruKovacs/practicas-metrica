package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBBDD {

	private static Connection instance;
	
	private AccesoBBDD() {
		try {
			instance = DriverManager.getConnection("jdbc::mysql111.111.1.1:misDatos:admin:admin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection get() {
		if(instance == null) {
			new AccesoBBDD();
		}
		
		return instance;
	}
}
