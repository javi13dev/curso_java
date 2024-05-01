package principal;

import service.MiException;

public class Prueba {
	//1) Primero creo un método para probar y lanzar la exception:
	public void metodoConExcepcion() throws MiException{
		// Y con el throw se lanza el método con el mensaje personalizado:
		throw new MiException("Excepcion personalizada");
	}
	
	// 3) Probamos el otro método:
	public void metodoConParametro(int edad) throws MiException{
		// Se usa new y no un throw porque no se sabe si la condición se va a  cumplir
		// Si cumple se mostrará el mensaje de la exception
		new MiException(edad);
		// Si no, mostrará el siguiente mensaje
		System.out.println("Es mayor de edad");
	}
	
	
	public static void main(String[] args) {
		// 2) probamos a crear un objeto:
		Prueba prueba = new Prueba();
		try {
			prueba.metodoConExcepcion();
			// Y se controla en el catch con Mi exception
		} catch (MiException e) {
			System.out.println(e.getMessage());
		
		}
		
		
		try {
			prueba.metodoConParametro(10);
		} catch (MiException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
