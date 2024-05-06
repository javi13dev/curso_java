package service;

public class SingletonService {
	// habrá una variable que sea única para todos:
	private static SingletonService instance;
	
	// A esa clase para que sea única, no debe poder usarse el new()
	// para eso debe ser privado
	private SingletonService() {
		// Aqui el objeto recién creado se guarda
		instance=this;
	}
	
	public static SingletonService getInstance() {
		// Cuando se crea, cuando no lo haya
		if(instance == null) {
			new SingletonService();
		}
		return instance;
	}
}
