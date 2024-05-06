package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Municipio;

public class MunicipioService {
	
	String cadenaConexion="jdbc:mysql://localhost:3306/administraciones";
	String usuario="root";
	String password="root";
	
	public Municipio municipioPorId(int idCodigo) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from municipios where codigo=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, idCodigo);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return new Municipio(rs.getInt("codigo"),
							rs.getString("nombre"),
							rs.getDouble("superficie"),
							rs.getInt("poblacion"),
							rs.getInt("altura"),
							rs.getString("provincia"));
			}
				
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean altaMunicipio(Municipio municipio) {
		if(municipioPorId(municipio.getCodigo())!=null) {
			return false;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="insert into municipios(codigo,nombre,superficie,poblacion,altura,provincia) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			//sustituimos parámetros por valores
			ps.setInt(1, municipio.getCodigo());
			ps.setString(2, municipio.getNombre());
			ps.setDouble(3, municipio.getSuperficie());
			ps.setInt(4, municipio.getPoblacion());
			ps.setInt(5, municipio.getAltura());
			ps.setString(6, municipio.getProvincia());
			ps.execute();//NO se manda otra vez la SQL
			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
