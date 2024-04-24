package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TestEscritura {

	public static void main(String[] args) {
		String ruta = "nombres.txt";
		
		// Primero, crear el Path, con el método of:
		Path pt = Path.of(ruta);
		
		// Deben capturarse las excepciones
		// El printStackTrace es para saber lo que ha ocurrido en el proceso.
		
		try {	
			if(Files.notExists(pt)) {
				Files.createFile(pt);
			}
			// Files.writeString(pt, "cadena1", StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			// la segunda condición sustituye el if
			Files.writeString(pt, "cadena1", StandardOpenOption.APPEND);
			Files.writeString(pt, "cadena2\n", StandardOpenOption.APPEND);
			Files.writeString(pt, "cadena3", StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
