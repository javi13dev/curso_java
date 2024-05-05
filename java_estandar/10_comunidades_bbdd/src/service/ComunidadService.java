package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Comunidad;

public class ComunidadService {
	
	String cadenaConexion="jdbc:mysql://localhost:3306/administraciones";
	String usuario="root";
	String password="12345";
	
	public Comunidad comunidadPorId(int idCodigo) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from comunidades where codigo=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, idCodigo);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return new Comunidad(rs.getInt("codigo"),
							rs.getString("nombre"));
			}
				
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean altaComunidad(Comunidad comunidad) {
		if(comunidadPorId(comunidad.getCodigo())!=null) {
			return false;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="insert into comunidades(codigo,nombre) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setInt(1, comunidad.getCodigo());
			ps.setString(2, comunidad.getNombre());
			ps.execute();//NO se manda otra vez la SQL
			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
