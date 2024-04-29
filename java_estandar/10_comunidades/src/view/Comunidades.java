package view;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import model.Municipio;
import model.Provincia;
import service.ComunidadesService;

public class Comunidades {

	static ComunidadesService service = new ComunidadesService();
	
	public static void main(String[] args) {
		
		//System.out.println(service.mostrarProvincias());
		
		System.out.println(" Comunidades autónomas:  "); 
		
		service.mostrarProvincias().forEach(s -> System.out.println(s));
		
		System.out.println(" ----------------  ");
		
		
		System.out.println(" Provincias values: ");
		service.mostrarProvinciasPorComunidad().values().forEach(s -> System.out.println(s));
		
		
		System.out.println(" ----------------  ");
		
		
		
		System.out.println(" Las keys: ");
		service.mostrarProvinciasPorComunidad().keySet().forEach(s -> {
			System.out.println(s);
			System.out.println("Sus municipios: ");
			System.out.println(service.mostrarMunicipiosPorProvincia(s).values());

			
		});
		
	}

}
