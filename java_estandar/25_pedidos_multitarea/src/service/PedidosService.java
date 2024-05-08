package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {
	List<Pedido> obtenerPedidos(String dir);
	void save(List<Pedido> pedidos);
}
