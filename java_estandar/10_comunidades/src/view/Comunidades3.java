package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Municipio;
import model.Provincia;
import service.ComunidadesService;

public class Comunidades3 {

	static ComunidadesService service = new ComunidadesService();
	
	public static void main(String[] args) {

		// Para poder recorrerlas uso la interfaz Entry, me daba menos errores:
		
		//Map<String, List<Provincia>> provinciasPorComunidad = service.mostrarProvinciasPorCcaa();
		
		/*
		service.mostrarProvinciasStream()
		.map(p -> p.getCcaa())
		.distinct()
		.forEach(n -> System.out.println("Comunidad Autónoma: " + n));
		*/
		
		
		service.mostrarProvinciasStream()
		.map(p -> p.getCcaa())
		.distinct()
		.forEach(n -> {
			System.out.println("Comunidad Autónoma: " + n);
			
			service.mostrarProvinciasStream()
			.flatMap(mun -> mun.getMunicipios().stream())
			.forEach(nom -> {
				if(n.equals(nom.getNombre())) {
					System.out.println("          Provincia: " + nom);
				}
			});
		});
		

		service.mostrarProvinciasStream()
		//.flatMap(n -> n.getMunicipios().stream())
		.forEach(n ->{
			service.mostrarMunicipiosStream(n.getNombre())
			.forEach(muni ->{
				System.out.println(muni);
			});
		});
		
		
		/*
		
		for (Map.Entry<String, List<Provincia>> entry : provinciasPorComunidad.entrySet()) {
			String ccaa = entry.getKey();
			List<Provincia> provincias = entry.getValue();
			
			System.out.println("Comunidad Autónoma: " + ccaa);
			System.out.println("        Provincias:");
			
			for (Provincia p : provincias) {
				System.out.println("            - " + p.getNombre());
				
				service.mostrarProvinciasPorComunidad().keySet().forEach(s -> {
					// Otro map a recorrer, lento
					Map<String, List<Municipio>> municipiosPorProvincia = service.mostrarMunicipiosPorProvincia(s);
					
					for (Map.Entry<String, List<Municipio>> entryMunicipios : municipiosPorProvincia.entrySet()) {
						String provinciaKey = entryMunicipios.getKey();
						if(p.getNombre().equals(provinciaKey)) {
							
							List<Municipio> municipios = entryMunicipios.getValue();

							System.out.println("                   Municipios:");
							for (Municipio municipio : municipios) {
								System.out.println("                        - " + municipio.getNombre());
							}
							
						}
					}
				});
				
			}
		}*/
	}

}
