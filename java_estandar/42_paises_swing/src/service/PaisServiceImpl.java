package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pais;

public class PaisServiceImpl implements PaisService {
	
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
	
	
	private Stream<Pais> getPaises(){
		
		// Mediante http:
		String url = "https://restcountries.com/v2/all";
		Gson gson=new Gson();
		
		HttpRequest request = HttpRequest.newBuilder() 
				.uri(URI.create(url))
				.GET() //método de envío 
				.build();
		
		// Ahora realizar la llamada:
		HttpClient client = HttpClient.newBuilder()
				.build();
		
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			// Tenemos la respuesta, a partir del objeto response, métodos de acceso:
			// body() o si queremos las cabeceras headers()
			return Arrays.stream(gson.fromJson(response.body(), Pais[].class));
			// Ojo, fromJson, y los parámetros, devuelve un array del tipo de clase del segundo parámetro.
			// De ahí, lo pasamos a un stream con Arrays.stream() para manipular los datos.
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	} 
	
	//  Lista de continentes
	@Override
	public List<String> mostrarContinentes(){
		return getPaises()
				.map(p -> p.getContinente())
				.distinct()
				.toList();
	}
	
	// Lista de paises a partir del continente
	@Override
	public List<Pais> mostrarPaises(String continente){
		return getPaises()
				.filter(p -> p.getContinente().equals(continente))
				.toList();
	}
	
	// Pais más poblado
	@Override
	public Pais paisMasPoblado(){
		return getPaises()
				.max(Comparator.comparingInt(p -> p.getHabitantes()))
				.orElse(null);
	}
	
	
	// Tabla con paises agurpados por continente
	
	//public Map<String, List<Pais>> paisesPorContinente(){
		
	//}
	@Override
	public Map<String, List<Pais>> paisesPorContinente() {
		return getPaises() 
				.collect(Collectors.groupingBy(p -> p.getContinente()));
	} 
	
	
	// Pais a partir de su capital

	@Override
	public Optional<Pais> mostrarPaisPorCapital(String capital){
		return getPaises()
				.filter(p -> p.getCapital() != null && p.getCapital().equals(capital))//Stream<Pais>
				.findFirst();//Optional<Pais>
	
	}
	
	@Override
	public String getPaisFiltradoPor(String capital)  {
		return getPaises()
		.filter(p -> p.getCapital() != null && p.getCapital().equals(capital))//Stream<Pais>
		.findFirst()//Optional<Pais>
		.map(p->p.getNombre())//Optional<String>
		.orElse("");
	} 
	

}
