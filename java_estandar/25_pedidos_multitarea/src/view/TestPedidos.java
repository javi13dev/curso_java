package view;

import java.util.List;

import dao.PedidosDaoFactory;
import model.Pedido;
import service.PedidosService;
import service.PedidosServiceImpl;
import tareas.SaveData;

public class TestPedidos {

	public static void main(String[] args) {
		PedidosServiceImpl pedido = new PedidosServiceImpl();
		
		
		List<Pedido> pedidos = pedido.obtenerPedidos("tienda1.json");
		List<Pedido> pedidos2 = pedido.obtenerPedidos("tienda2.json");
		List<Pedido> pedidos3 = pedido.obtenerPedidos("tienda3.json");
		
		//pedidos.forEach(p -> System.out.println(p.getProducto()));
		//pedido.save(pedidos);
		
		new Thread(new SaveData(pedidos)).start();
		new Thread(new SaveData(pedidos2)).start();
		new Thread(new SaveData(pedidos3)).start();
		

	}

}
