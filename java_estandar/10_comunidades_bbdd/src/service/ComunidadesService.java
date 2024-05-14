package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Comunidad;
import model.InfoMunicipios;
import model.InfoProvincias;
import model.Municipio;
import model.Provincia;



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
			// Devuelvo la lista de provincias (de clase InfoProvincias) en stream
			return gson.fromJson(response.body(), InfoProvincias.class).getProvincias().stream();
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
			return gson.fromJson(response.body(), InfoMunicipios.class).getMunicipios().stream();	
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	} 
	
	
	public List<Provincia> mostrarProvincias(String comunidad){
		return getProvincias()
				.filter(p -> p.getCcaa().equals(comunidad))
				.toList();
	}
	
	public List<Municipio> mostrarMunicipios(String provincia){
		return getMunicipios(provincia)
				.toList();
	}
	
	
	public List<Comunidad> mostrarComunidades(){
		List<Comunidad> comunidades = new ArrayList<>();
	
    	getProvincias()
    	.forEach(p -> {
	    		comunidades.add(new Comunidad(p.getCodigoCcaa(), p.getCcaa()));
    	});
        return comunidades;
	}

}