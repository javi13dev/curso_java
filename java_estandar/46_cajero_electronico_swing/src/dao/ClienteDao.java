package dao;

import java.util.List;

import model.Cliente;

public interface ClienteDao {
	List<Cliente> findByCuenta(int idCuenta);
}
