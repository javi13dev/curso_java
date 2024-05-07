package dao;

import java.util.List;

import model.Movimiento;

public interface MoviminetosDao {
	List<Movimiento> findByCuenta(int idCuenta);
	void save(Movimiento movimiento);
}
