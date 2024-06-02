package service;

public class GatoServiceFactory {
	public static GatoService getGatoService() {
		return new GatoServiceImpl();
	}
}
