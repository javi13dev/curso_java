package service;

import java.util.List;

import dao.PedidosDao;
import dao.PedidosDaoFactory;
import model.Pedido;

public class PedidosServiceImpl implements PedidosService {
	
	PedidosJsonService service = new PedidosJsonService();
	PedidosDao pedidosDao;
	
	public PedidosServiceImpl() {
		pedidosDao = PedidosDaoFactory.getPedidosDao();
	}
	
	@Override
	public List<Pedido> obtenerPedidos(String dir) {
		return service.getPedidos(dir);
	}

	@Override
	public void save(List<Pedido> pedidos) {
		pedidosDao.save(pedidos);
	}

}
