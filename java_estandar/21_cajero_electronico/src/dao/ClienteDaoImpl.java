package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	@Override
	public List<Cliente> findByCuenta(int idCuenta) {
		List<Cliente> clientes = new ArrayList<>();
		try (Connection con= LocatorConnection.getConnection();){
			String sql="select *  from clientes where numeroCuenta=?";
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
