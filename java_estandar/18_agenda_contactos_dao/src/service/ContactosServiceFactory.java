package service;

public class ContactosServiceFactory {
	public static ContactosService getContactosService() {
		// La factoria sí tiene que conocer la clase. El cliente no.
		return new ContactosServiceImpl();
	}
}
