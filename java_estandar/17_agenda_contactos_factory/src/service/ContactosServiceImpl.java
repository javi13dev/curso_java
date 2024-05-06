package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;

public class ContactosServiceImpl implements ContactosService {
	// Esta va a ser la clase que implemente la interfaz : refactor --> extract Interface
	
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
	@Override
	public boolean nuevoContacto(Contacto contacto) {

		// Si hay un nuevo contacto con ese email, no se añadirá y devolverá false
		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "select * from contactos";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				if(!rs.getString("email").equals(contacto.getEmail())) {
					// sustituimos parámetros por valores:
					String sqlInsert = "insert into contactos (nombre, email, edad) values (?, ?, ?)";
					PreparedStatement ps = conn.prepareStatement(sqlInsert);
					ps.setString(1, contacto.getNombre());
					ps.setString(2, contacto.getEmail());
					ps.setInt(3, contacto.getEdad());
					ps.execute();
					// la primera llamada que no haya next, no devuelve nada. No sería error.
					return true;
				}
			}
			// De esta forma la sql se ha proporcionado antes, no en la ejecución.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	// Nuevo contacto con el método privado:
	
	@Override
	public boolean nuevoContactoPrivado(Contacto contacto) {

		// Si hay un nuevo contacto con ese email, no se añadirá y devolverá false
		if(existeEmail(contacto.getEmail())) {
			return false;
		}
		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {

				// sustituimos parámetros por valores:
				String sqlInsert = "insert into contactos (nombre, email, edad) values (?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(sqlInsert);
				ps.setString(1, contacto.getNombre());
				ps.setString(2, contacto.getEmail());
				ps.setInt(3, contacto.getEdad());
				ps.execute();
				// la primera llamada que no haya next, no devuelve nada. No sería error.
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	// Eliminar contacto, devuelve el contacto eliminado.
	// Si no se ha eliminado ninguno, devuelve null.
	@Override
	public Contacto eliminarContacto(String email) {

		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "select * from contactos";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("email").equals(email)) {
					
					String sqlQuery = "delete from contactos where email = ?";
					PreparedStatement ps = conn.prepareStatement(sqlQuery);
					ps.setString(1, email);
					ps.execute();
					return new Contacto(rs.getString("nombre"), rs.getString("email"), rs.getInt("edad"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// con método privado:
	@Override
	public Contacto eliminarContactoPrivado(String email) {
		
		Contacto contacto = buscarContactoPorEmail(email);
		if(contacto == null) {
			return null;
		}
		
		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {

			String sqlQuery = "delete from contactos where email = ?";
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setString(1, email);
			ps.execute();
			return contacto;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	// Actualizar edad
	@Override
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
	
	
	
	// Buscar contacto por su clave primaria
	@Override
	public Contacto buscarContactoPorId(int idContacto) {

		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "select * from contactos where idContacto = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idContacto);
			ResultSet rs = st.executeQuery();
			
			// debemos movernos a la primera y única fila para poder extraer el valor de dicha fila
			// Porque si no movemos y no habia fila, habría sido null.
			if(rs.next()){
				return new Contacto(rs.getInt("idContacto"), rs.getString("nombre"), rs.getString("email"), rs.getInt("edad"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	// Recuperar todos los contactos, como una lista
	
	@Override
	public List<Contacto> getContactos(){
		List<Contacto> contactos = new ArrayList<Contacto>();
		// Hay que recorrer cada fila que me devuelve el resultset e ir construyendo los objetos para rellenar el List.
		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "select * from contactos";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				contactos.add(new Contacto(rs.getInt("idContacto"), rs.getString("nombre"), rs.getString("email"), rs.getInt("edad")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactos;
	}
	
	
	
	// Buscar contacto por su clave primaria
	private Contacto buscarContactoPorEmail(String email) {

		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "select * from contactos where email = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			
			// debemos movernos a la primera y única fila para poder extraer el valor de dicha fila
			// Porque si no movemos y no habia fila, habría sido null.
			if(rs.next()){
				return new Contacto(rs.getString("nombre"), rs.getString("email"), rs.getInt("edad"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private boolean existeEmail(String email) {

		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "select * from contactos where email = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
