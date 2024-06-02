package dao;

public class GatosDaoFactory {
	
	public static GatosDao getGatosDato() {
		return new GatosDaoImpl();
	}

}
