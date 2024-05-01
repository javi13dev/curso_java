package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {
	public static void main (String[] args) throws IOException {
		String ruta = System.getProperty("user.home")+"/MiFichero"; // Se está guardando con el nombre MiFichero
		
		try {
			FileReader filereader = new FileReader(ruta);
			
			BufferedReader bf = new BufferedReader(filereader);
			
			String linea;
			while((linea = bf.readLine()) != null) {
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
