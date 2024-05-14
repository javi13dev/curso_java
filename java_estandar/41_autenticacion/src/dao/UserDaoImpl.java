package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Usuario;

public class UserDaoImpl implements UserDao {

	@Override
	public Usuario findUsuario(String usuario) {
		try(Connection conn = LocatorConnection.getConnection())  {
			String sql = "select * from clientes where usuario = ?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, usuario);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Usuario(rs.getInt("idCLiente"),
						rs.getString("usuario"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getInt("telefono"));
			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
