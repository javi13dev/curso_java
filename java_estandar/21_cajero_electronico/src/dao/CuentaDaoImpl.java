package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import locator.LocatorConnection;
import model.Cuenta;

class CuentaDaoImpl implements CuentaDao {

	@Override
	public Cuenta findById(int idCuenta) {
		try (Connection con=LocatorConnection.getConnection();){
			String sql="select * from cuentas where numeroCuenta=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idCuenta);			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return  new Cuenta(rs.getInt("numeroCuenta"),
						rs.getDouble("saldo"),
						rs.getString("tipocuenta"));
				
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}


	public double getSaldo(int idCuenta) {
		
		if(findById(idCuenta) == null) {
			return 0.0;
		}else {
			return findById(idCuenta).getSaldo();
		}
	}
	

	@Override
	public void updateSaldo(int idCuenta, double nuevoSaldo) {
		try(Connection conn = LocatorConnection.getConnection())  {
			String sql = "update  cuentas set saldo = ? where numeroCuenta = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, nuevoSaldo);
			ps.setInt(2, idCuenta);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
