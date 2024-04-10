package curso.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LectorTeclado extends BufferedReader {
	
	// Probamos esta clase en el proyecto 51 del workspace clase
	
	/**
	 * Crear una clase para lectura de datos por teclado.
	 * Esa clasetendrá tres métodos:
	 * readString()
	 * readInt()
	 * readDouble()
	 */

	/**
	 * Usamos la clase BufferedReader (hecha para lectura),una clase que herede. 
	*/

	
	public LectorTeclado() {
		super(new InputStreamReader(System.in));
		
	}
	
	public String readString() {
		// return this.readLine()
		try {
			return readLine();
		} catch (IOException e) {
			// El e.printStackTrace() lo borraré
			e.printStackTrace();
			return null;
		}
	}
	
	public int readInt() {
		try {
			return Integer.parseInt(readLine());
		} catch (IOException e) {
			// El e.printStackTrace() lo borraré
			e.printStackTrace();
			return 0;
		}
	}
	
	public double readDouble() {
		try {
			return Double.parseDouble(readLine());
		} catch (IOException e) {
			// El e.printStackTrace() lo borraré
			e.printStackTrace();
			return 0.0;
		}
	}
}

// Para usar esta clase en otros proyectos, hay que generar .jar (librerias)

// En el proyecto>export>java>jar file> clase y ubicación
