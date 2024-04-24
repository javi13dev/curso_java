package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestLectura {

	public static void main(String[] args) {
		String ruta = "nombres.txt";
		
		// Primero, crear el Path, con el método of:
		Path pt = Path.of(ruta);
		
		try {
			Files.lines(pt)
			.forEach(s->System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
