package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AgregarResult {

		public static void main(String[] args) {
			
			// Definimos la cadena necesaria para la conexión:
			
			String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
			String usuario = "root";
			String password = "root";

			try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
				// Con el try con recursos no nos hace falta llamar al conn.close()
				String sql = "select * from contactos";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					// la primera llamada que no haya next, no devuelve nada. No sería error.
					System.out.println(rs.getString("nombre")+ "-" + rs.getInt("edad"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	

}
