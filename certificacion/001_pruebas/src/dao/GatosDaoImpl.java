package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Gato;

public class GatosDaoImpl implements GatosDao{

	@Override
	public Gato findGato(String name) {
		try(Connection con = LocatorConnection.getConnection()) {
			String sql="select * from gatos where nombre=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return  new Gato(rs.getString("nombre"),
						rs.getInt("peso"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Gato> listGatos() {
		List<Gato> gatitos = new ArrayList<>();
		try (Connection con= LocatorConnection.getConnection();){
			String sql="select * from gatos";
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				gatitos.add(new Gato(rs.getString("nombre"), rs.getInt("peso")));
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return gatitos;
	}

	@Override
	public void deleteGato(String nombre) {
		try (Connection con = LocatorConnection.getConnection()){
			String sql = "delete gatos where nombre = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void updateGato(String nombre, int peso) {
		// Podria comprobar previamente si la cuenta existe.
		try (Connection con = LocatorConnection.getConnection()){
			String sql = "update  gatos set peso = ? where nombre = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, peso);
			ps.setString(2, nombre);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
