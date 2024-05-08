package dao;

import java.util.List;

import model.Pedido;

public interface PedidosDao {
	void save(List<Pedido> pedidos);
}
