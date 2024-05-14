package service;

public class UsuarioServiceFactory {
	public static UsuarioService getUsuarioService() {
		return new UsuarioServiceImpl();
	}
}
