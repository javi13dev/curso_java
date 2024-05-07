package dao;

import java.util.List;

import model.Cuenta;

public interface CuentaDao {
	
	Cuenta findById(int idCuenta);
	void updateSaldo(int idCuenta, double nuevoSaldo);

}
