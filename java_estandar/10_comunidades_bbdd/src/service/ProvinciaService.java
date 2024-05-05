package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Provincia;

public class ProvinciaService {
	
	String cadenaConexion="jdbc:mysql://localhost:3306/administraciones";
	String usuario="root";
	String password="12345";
	
	public Provincia provinciaPorId(String idCodigo) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from provincias where codigo=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, idCodigo);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return new Provincia(rs.getString("nombre"),
							rs.getString("codigo"),
							rs.getInt("codigoCcaa"),
							rs.getString("ccaa"));
			}
				
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean altaProvincia(Provincia provincia) {
		if(provinciaPorId(provincia.getCodigo())!=null) {
			return false;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="insert into provincias(codigo,nombre, comunidad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setString(1, provincia.getCodigo());
			ps.setString(2, provincia.getNombre());
			ps.setString(3, provincia.getCcaa());
			ps.execute();//NO se manda otra vez la SQL
			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
