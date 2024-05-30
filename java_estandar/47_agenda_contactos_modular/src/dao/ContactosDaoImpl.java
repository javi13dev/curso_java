package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Contacto;

public class ContactosDaoImpl implements ContactosDao {
	// Para optimizar, usaremos el locator de connection
	@Override
	public void save(Contacto contacto) {
		try(Connection conn = LocatorConnection.getConnection())  {
			// Este método se dedica exclusivamente a una tarea determinada.
			String sqlInsert = "insert into contactos (nombre, email, edad) values (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sqlInsert);
			ps.setString(1, contacto.getNombre());
			ps.setString(2, contacto.getEmail());
			ps.setInt(3, contacto.getEdad());
			ps.execute();

			// De esta forma la sql se ha proporcionado antes, no en la ejecución.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Contacto findByEmail(String email) {
		try(Connection conn = LocatorConnection.getConnection())  {
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

	@Override
	public void update(Contacto contacto) {
		try(Connection conn = LocatorConnection.getConnection())  {
			String sql = "update  contactos set nombre = ?, email = ?, edad = ? where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// sustituimos parámetros por valores:
			ps.setString(1, contacto.getNombre());
			ps.setString(2, contacto.getEmail());
			ps.setInt(3, contacto.getEdad());
			ps.execute();
			
			// si queremos que sea boolean :
			// return ps.executeUpdate() >0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Contacto findById(int idContacto) {
		try(Connection conn = LocatorConnection.getConnection())  {
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

	@Override
	public List<Contacto> findAll() {
		List<Contacto> contactos = new ArrayList<Contacto>();
		// Hay que recorrer cada fila que me devuelve el resultset e ir construyendo los objetos para rellenar el List.
		try(Connection conn = LocatorConnection.getConnection())  {
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

	@Override
	public void deleteByEmail(String email) {

		try(Connection conn = LocatorConnection.getConnection())  {

			String sqlQuery = "delete from contactos where email = ?";
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setString(1, email);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
