package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Info;
import model.InfoMunicipios;
import model.Municipio;
import model.Provincia;

/**
 * Proyecto comunidades:

	Realizar una aplicación que muestre el nombre de cada comunidad autónoma, y para cada una
	mostrará sus provincias y dentro de esta, sus municipios.
	
	Datos:
	
	- Provincia:
		nombre
		int codigo
		CCAA
		
	- Municipio:
		nombre
		provincia
		poblacion
		
		
	Ej:
	
	Comunidad Madrid:
		Madrid:
			municipio 1
			municipio 2
			....
			
	https://www.el-tiempo.net/api
 */


public class ComunidadesService {
	
	private Stream<Provincia> getProvincias(){
		
		// Mediante http:
		String url = "https://www.el-tiempo.net/api/json/v2/provincias";
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
			// Necesito obtener un array, no el objeto que devuelve.
			Info infoProvincias = gson.fromJson(response.body(), Info.class);
			Provincia [] provincias = infoProvincias.getProvincias();
			// Paso el array para tener el stream
			return Arrays.stream(provincias);
			
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	} 
	
	
	// get municipios:
	
	private Stream<Municipio> getMunicipios(String provincia){
		
		String url = "https://www.el-tiempo.net/api/json/v2/provincias/"+provincia+"/municipios";
		//System.out.println(url);
		Gson gson=new Gson();
		
		HttpRequest request = HttpRequest.newBuilder() 
				.uri(URI.create(url))
				.GET() //método de envío 
				.build();
		
		HttpClient client = HttpClient.newBuilder()
				.build();
		
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			InfoMunicipios infoMunicipios = gson.fromJson(response.body(), InfoMunicipios.class);
			Municipio [] municipios = infoMunicipios.getMunicipios();
			return Arrays.stream(municipios);
			
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	} 
	
	/*
	public Stream<Provincia> mostrarInfo(){
		return getProvincias()
				.flatMap(p -> p.getProvincias());
	}
	*/
	
	
	public Stream<Provincia> mostrarProvinciasStream(){
		return getProvincias();

	}
	
	
	
	
	
	public List<String> mostrarProvincias(){
		return getProvincias()
				.map(p -> p.getCcaa())
				.distinct()
				.toList();
	}
	
	public Map<String, List<Provincia>> mostrarProvinciasPorComunidad(){
		return getProvincias()
				.collect(Collectors.groupingBy(p -> p.getCodigo()));

	}
	
	/*
	
	public List<Municipio> mostrarProvinciasPorCCAA(){
		return getProvincias()
				.flatMap(p -> p.getMunicipios().stream())
				.map(p -> p)
				.toList();

	}
	
	*/
	
	
	
	/*
	public List<Municipio> municipiosPorCodigoProvincia(){
		// 
		return getProvincias()
				.map(p -> p.getCcaa())
				.forEach(s -> getMunicipios(s))
				.map(s -> s.);
			

	}
	*/
	
	
	public Map<String, List<Municipio>> mostrarMunicipiosPorProvincia(String provincia){
		return getMunicipios(provincia)
				.collect(Collectors.groupingBy(m -> m.getProvincia()));

	}
	
	/*
	public List<String> mostrarMunicipios(){
		
		mostrarProvincias()
		.forEach(s -> mostrarMunicipios(s));
		
		return getProvincias()
				.map(p -> p.getCcaa())
				.distinct()
				.forEach(s -> ComunidadesService.getMunicipios(s))
	}
	
	public List<String> mostrarMunicipios(){
		
		mostrarProvincias()
		.forEach(s -> mostrarMunicipios(s));
		
		return getProvincias()
				.map(p -> p.getCcaa())
				.distinct()
				.forEach(s -> ComunidadesService.getMunicipios(s))
	}
	*/
}
