package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Contacto;

public class AgendaService {

	
	/**
	1.-Nuevo Contacto
	2.-Eliminar Contacto
	3.-Actualizar edad
	4.-Salir
	
	1: Se piden los datos del nuevo contacto y se guarda
	2: Solicita el email y borra el contacto con dicho email
	3: Solicita email y nueva edad, y sustituye la edad anterior por la nueva en ese contacto 
	 */
	
	String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
	String usuario = "root";
	String password = "root";
	
	// Nuevo contacto:
	public void addContacto(Contacto contacto) {

		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "insert into contactos (nombre, email, edad) values (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			// sustituimos parámetros por valores:
			ps.setString(1, contacto.getNombre());
			ps.setString(2, contacto.getEmail());
			ps.setInt(3, contacto.getEdad());
			// De esta forma la sql se ha proporcionado antes, no en la ejecución.
			ps.execute();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Eliminar contacto
	public void eliminarContacto(String email) {

		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "delete from contactos where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// Actualizar edad
	public void actualizarEdad(String email, int edad) {

		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "update  contactos set edad = ? where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// sustituimos parámetros por valores:
			ps.setInt(1, edad);
			ps.setString(2, email);
			// De esta forma la sql se ha proporcionado antes, no en la ejecución.
			ps.execute();
			
			// si queremos que sea boolean :
			// return ps.executeUpdate() >0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
