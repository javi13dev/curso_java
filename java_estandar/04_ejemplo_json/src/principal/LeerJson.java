package principal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Ciudad;

public class LeerJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dir ="C:\\Users\\manana\\Desktop\\java\\java_estandar\\apuntes\\prueba_json.json";
		
		// Para leer, primero crear un objeto GSON
		Gson gson = new Gson();
		// Y llamar a un método fromJson()
		
	
		// Como gson.fromJson, nos da un array, y queremos una lista, se usa el Arrays.asList
		// El segundo parámetor indica a qué quiero convertirlo, en este caso, a un array de objetos java: Ciudad[].class
		try {
			List<Ciudad> ciudades = Arrays.asList(gson.fromJson(new FileReader(dir), Ciudad[].class));
			ciudades.forEach(c -> System.out.println(c + " " + c.getCiudad()));
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
