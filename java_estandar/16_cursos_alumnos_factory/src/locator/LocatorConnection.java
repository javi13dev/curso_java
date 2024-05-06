package locator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocatorConnection {
	static String cadenaConexion="jdbc:mysql://localhost:3306/formacion";
	static String usuario="root";
	static String password="root";
	
	// lo normal es que este método sea estático, o bien se cree mediante singleton
	public static Connection getConnection() throws SQLException {
		// En este caso no capturamos la exepción, sino que la pasamos
		return DriverManager.getConnection(cadenaConexion,usuario,password);
	}
}
