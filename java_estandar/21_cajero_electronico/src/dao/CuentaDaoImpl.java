package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import locator.LocatorConnection;
import model.Cuenta;

public class CuentaDaoImpl implements CuentaDao {

	@Override
	public Cuenta findById(int idCuenta) {
		Cuenta cuenta = null;
		try (Connection con=LocatorConnection.getConnection();){
			String sql="select * from cuentas where numeroCuenta=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idCuenta);			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				cuenta =  new Cuenta(rs.getInt("numeroCuenta"),
						rs.getDouble("saldo"),
						rs.getString("tipocuenta"));
				
			}
			return cuenta;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
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
			// sustituimos parámetros por valores:
			ps.setDouble(1, nuevoSaldo);
			ps.setInt(2, idCuenta);
			ps.execute();
			
			// si queremos que sea boolean :
			// return ps.executeUpdate() >0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
