import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestPropagacion {
	// Ejemplo en lógica de negocio:
	
	// Sobre si no quiero caputar la excepción ni lanzarla a la capa de presentación.
	public String getData() throws DatoNoEncontradoException{ // Paso final, esta exception sí debe conocerla la capa de presentación.
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader("datos.txt"));
			return bf.readLine();
			
		} catch (IOException e) {
			// Si quiero personalizar el control de la exepcion:
			throw new DatoNoEncontradoException();
		}

	}
}
