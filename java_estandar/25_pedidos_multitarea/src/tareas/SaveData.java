package tareas;

import java.util.List;

import model.Pedido;
import service.PedidosServiceImpl;

public class SaveData implements Runnable {
	
	private List<Pedido> pedidos;
	
	public SaveData(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	@Override
	public void run() {
		PedidosServiceImpl pedido = new PedidosServiceImpl();
		pedido.save(pedidos);
	}
}
