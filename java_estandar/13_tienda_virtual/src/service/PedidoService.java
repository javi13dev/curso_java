package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class PedidoService {
	
	String cadenaConexion ="jbdc:mysql://localhost.3306/tiendavirtual";
	String usuario = "root";
	String password = "root";
	
	
	
	// guardar pedido
	public void guardarPedido(Pedido pedido) {
		try(Connection con = DriverManager.getConnection(cadenaConexion);) {
			String sql = "insert into pedidos(unidades, total, fechaPedido, codigoProducto) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pedido.getUnidades());
			ps.setDouble(2,pedido.getTotal());
			// Aqui con el método estático de Timestamp, pasamos un localDateTime a timestamp
			ps.setTimestamp(3, Timestamp.valueOf(pedido.getFechaPedido()));
			ps.setInt(4, pedido.getCodigoProducto());
			ps.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	// pedidos entre fechas
	public List<Pedido> pedidosEntreFechas(LocalDateTime f1, LocalDateTime f2){
		List<Pedido> pedidos = new ArrayList();
		
		// Definimos la cadena necesaria para la conexión:
		
		String cadenaConexion = "jdbc:mysql://localhost:3306/tiendavirtual";
		String usuario = "root";
		String password = "root";
		
		
		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			// Con el try con recursos no nos hace falta llamar al conn.close()
			String sql = "select * from pedidos where fechaPedido >= ? and fechaPedido<=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, Timestamp.valueOf(f1));
			ps.setTimestamp(2, Timestamp.valueOf(f2));

			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				pedidos.add(new Pedido(rs.getInt("idPedido"),
						rs.getInt("unidades"),
						rs.getDouble("total"),
						rs.getTimestamp("fechaPedido").toLocalDateTime(),
						rs.getInt("codigoProducto")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List.of();
	}
}
