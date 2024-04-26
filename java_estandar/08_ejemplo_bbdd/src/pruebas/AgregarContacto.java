package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AgregarContacto {

	public static void main(String[] args) {
		
		// Definimos la cadena necesaria para la conexión:
		
		String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
		String usuario = "root";
		String password = "root";
		
		String name = "contacto4";
		String email = "prueban@gmail.com";
		int edad = 10;
		
		// Ahora hay que crear el objeto Connection con DriverManager:

		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			// Con el try con recursos no nos hace falta llamar al conn.close()
			
			// Siguiente paso ejecutar la consulta, st.
			/*
			String sql = "insert into contactos (nombre, email, edad) values ('"+name+"', '"+email+"', " + edad+ ")";
			Statement st = conn.createStatement();
			st.execute(sql);
			*/
			String sql = "insert into contactos (nombre, email, edad) values (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			// sustituimos parámetros por valores:
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, edad);
			// De esta forma la sql se ha proporcionado antes, no en la ejecución.
			ps.execute();

			System.out.println("Registro añadido");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
