package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Cliente;

class ClienteDaoImpl implements ClienteDao {

	@Override
	public List<Cliente> findByCuenta(int idCuenta) {
		List<Cliente> clientes = new ArrayList<>();
		try (Connection con= LocatorConnection.getConnection();){
			String sql="select clientes.*  from clientes, titulares where titulares.idCuenta = ? and titulares.idCliente = clientes.dni?";
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				clientes.add(new Cliente(rs.getInt("dni"),
						rs.getString("nombre"),
						rs.getString("direccion"),
						rs.getInt("telefono")));
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return clientes;
	}
}
