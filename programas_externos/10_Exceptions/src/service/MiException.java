package service;

public class MiException extends Exception{
	
	// Primero extiende
	
	// Luego con un constructor se puede indicar un mesaje llamando al constructor de Exception
	public MiException(String msg) {
		super(msg);
	}
	
	// Otra forma es pasarle un valor 
	public MiException(int edad) throws MiException{
		if(edad < 18) {
			throw new MiException("Debe ser mayor de edad");
		}
	}
}
