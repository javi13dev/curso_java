package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {

	public static void main(String[] args) throws IOException {
		
		// Esta propiedad de user.home indica la home del usuario.
		String ruta = System.getProperty("user.home")+"/MiFichero"; // Se está guardando con el nombre MiFichero
		
		// Creamos el archivo con File
		File archivo = new File(ruta);
		if(archivo.createNewFile()) {
			System.out.println("Se hac creado el fichero");
		}else {
			System.out.println("No se ha creado el fichero");
		}
		
		String texto = "Probando";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
		
		// a traves del writer escribimos:
		
		writer.write(texto);
		
		writer.close();
		
		
	}

}
