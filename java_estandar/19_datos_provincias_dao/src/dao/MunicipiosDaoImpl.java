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
import model.Municipio;

class MunicipiosDaoImpl implements MunicipiosDao {

	@Override
	public void save(List<Municipio> municipios) {
		try (Connection con= LocatorConnection.getConnection();){
			String sql="insert into municipios(codigo,nombre,codProvincia,superficie,altitud,poblacion) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			// Para preparar la transacción:
			// 1) Hay que cancelar el autocommit:
			con.setAutoCommit(false);
			// Con esto, todos los execute están en la misma transacción.
			
			for(Municipio m:municipios){
				ps.setString(1, m.getCodigo());
				ps.setString(2, m.getNombre());
				ps.setString(3, m.getCodProvincia());
				ps.setDouble(4, m.getSuperficie());
				ps.setInt(5, m.getAltitud());
				ps.setInt(6, m.getPoblacion());
				ps.execute();
			}
			
			// 2) Una vez realizadas las operaciones, hay que confirmar la transacción:
			con.commit();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<String> findCodigos() {
		List<String> codigos = new ArrayList<>();
		try (Connection con= LocatorConnection.getConnection();){
			String sql="select codigo from municipios";
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				codigos.add(rs.getString(1));
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return codigos;
	}

}
