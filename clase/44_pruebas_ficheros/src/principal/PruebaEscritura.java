package principal;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PruebaEscritura {

	public static void main(String[] args) {
		//String ruta="c:\\temp\\dias.txt";
		String ruta="dias.txt";
		try {
			PrintStream out=new PrintStream(ruta);
			out.println("viernes");
			out.println("sábado");
			out.println("domingo");
			System.out.println("Información almacenada en el fichero");
			out.close();
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}

}
