package dao;

public class CajeroDaoFactory {
	public static CuentaDao getCuentaDao() {
		return new CuentaDaoImpl();
	}
	
	public static MovimientosDao getMovimientosDao() {
		return new MovimientosDaoImpl();
	}
	
	public static ClienteDao getClienteDao() {
		return new ClienteDaoImpl();
	}
}
