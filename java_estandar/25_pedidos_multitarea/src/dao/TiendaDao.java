package dao;

import java.util.List;

import model.Pedido;

public interface TiendaDao {
	void save(List<Pedido> pedidos);
}
