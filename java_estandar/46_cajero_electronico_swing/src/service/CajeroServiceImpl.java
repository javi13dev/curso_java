package service;

import java.time.LocalDateTime;
import java.util.List;

import dao.CajeroDaoFactory;
import dao.ClienteDao;
import dao.CuentaDao;
import dao.MovimientosDao;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

class CajeroServiceImpl implements CajeroService{
	ClienteDao clientesDao;
	CuentaDao cuentasDao;
	MovimientosDao movimientosDao;
	
	// Y el constructor que use la factoria:
	public CajeroServiceImpl() {
		clientesDao = CajeroDaoFactory.getClienteDao();
		cuentasDao = CajeroDaoFactory.getCuentaDao();
		movimientosDao = CajeroDaoFactory.getMovimientosDao();
	}
	
	
	@Override
	public Cuenta obtenerCuenta(int idCuenta) {

		return cuentasDao.findById(idCuenta);
	}

	@Override
	public Cuenta extraccion(int idCuenta, double cantidad) {
		
		Cuenta cuenta = cuentasDao.findById(idCuenta);
		
		// Si existe cuenta y si hay saldo suficiente
		if(cuenta!=null && cuenta.getSaldo() > cantidad) {
			cuentasDao.updateSaldo(idCuenta, cuenta.getSaldo()-cantidad);
			movimientosDao.save(new Movimiento(0,idCuenta, LocalDateTime.now(), cantidad, "extraccion"));
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			return cuenta;
		}
		return null;
	}
	
	@Override
	public Cuenta ingreso(int idCuenta, double cantidad) {
		Cuenta cuenta = cuentasDao.findById(idCuenta);
		
		// Si existe cuenta y si hay saldo suficiente
		if(cuenta!=null) {
			cuentasDao.updateSaldo(idCuenta, cuenta.getSaldo()+cantidad);
			movimientosDao.save(new Movimiento(0,idCuenta, LocalDateTime.now(), cantidad, "ingreso"));
			cuenta.setSaldo(cuenta.getSaldo()+cantidad);
			return cuenta;
		}
		return null;
	}

	@Override
	public boolean transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad) {
		
		if(cuentasDao.findById(idCuentaOrigen)==null || 
				cuentasDao.findById(idCuentaDestino)==null ||
				cantidad>cuentasDao.findById(idCuentaOrigen).getSaldo()) {
			return false;
		}
		extraccion(idCuentaOrigen, cantidad);
		ingreso(idCuentaDestino, cantidad);
		return true;
	}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {
		return clientesDao.findByCuenta(idCuenta);
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int idCuenta) {
		return movimientosDao.findByCuenta(idCuenta);
	}

	@Override
	public double obtenerSaldo(int idCuenta) {

		Cuenta cuenta = cuentasDao.findById(idCuenta);
		return cuenta!=null?cuenta.getSaldo():0;
	}

}
