package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import locator.LocatorConnection;
import model.Pedido;

public class PedidosDaoImpl implements PedidosDao{

	@Override
	public void save(List<Pedido> pedidos) {
		
		try (Connection con=LocatorConnection.getConnection();){
			String sql="insert into pedidos(producto,tienda,precio) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);
			for(Pedido p:pedidos){
				ps.setString(1, p.getProducto());
				ps.setString(2, p.getTienda());
				//ps.setTimestamp(3, Timestamp.valueOf(p.getFechaPedido()));
				ps.setDouble(3, p.getPrecio());
				ps.execute();
			}
			con.commit();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

		
	}

}
