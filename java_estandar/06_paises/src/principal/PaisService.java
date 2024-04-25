package principal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pais;

public class PaisService {
	
	/**
	 * 
	 * 	Implementar lógica de negocio de una aplicación que proporcione información
		sobre paises. Cada pais se caracteriza por: nombre,continente,capital,habitantes
		
		-Lista de continentes
		-Lista de paises a partir del continente
		-Pais más poblado
		-Tabla con paises agurpados por continente
		-Pais a partir de su capital 
	 */
	
	String ruta="paises.json";
	private Stream<Pais> getPaises(){
		try {
			Gson gson=new Gson();
			return 
			Arrays.stream(gson.fromJson(new FileReader(ruta), Pais[].class));
		}
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	} 
	
	//  Lista de continentes
	public List<String> mostrarContinentes(){
		return getPaises()
				.map(p -> p.getContinente())
				.distinct()
				.toList();
	}
	
	// Lista de paises a partir del continente
	public List<Pais> mostrarPaises(String continente){
		return getPaises()
				.filter(p -> p.getContinente().equals(continente))
				.toList();
	}
	
	// Pais más poblado
	public Pais paisMasPoblado(){
		return getPaises()
				.max(Comparator.comparingInt(p -> p.getHabitantes()))
				.orElse(null);
	}
	
	
	// Tabla con paises agurpados por continente
	
	//public Map<String, List<Pais>> paisesPorContinente(){
		
	//}
	public Map<String, List<Pais>> paisesPorContinente() {
		return getPaises() 
				.collect(Collectors.groupingBy(p -> p.getContinente()));
	} 
	
	
	// Pais a partir de su capital

	public Pais mostrarPais(String capital){
		return (Pais) getPaises()
				.filter(p -> p.getCapital().equals(capital));
	}
}
