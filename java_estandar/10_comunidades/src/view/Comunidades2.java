package view;

import java.util.List;
import java.util.Map;

import model.Municipio;
import model.Provincia;
import service.ComunidadesService;

public class Comunidades2 {

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
		/*
		service.mostrarProvinciasPorComunidad().keySet().forEach(s -> {

			//System.out.println("Sus municipios: ");
			//System.out.println(service.mostrarMunicipiosPorProvincia(s));

			
			Map<String, List<Municipio>> municipiosPorProvincia = service.mostrarMunicipiosPorProvincia(s);
			
			// Iterar sobre el mapa para acceder a cada provincia y sus municipios
			for (Map.Entry<String, List<Municipio>> entry : municipiosPorProvincia.entrySet()) {
				String provincia = entry.getKey();
				List<Municipio> municipios = entry.getValue();
				
				System.out.println("Provincia: " + provincia);
				System.out.println("          Municipios:");
				
				// Iterar sobre la lista de municipios de la provincia actual
				for (Municipio municipio : municipios) {
					System.out.println("               - " + municipio.getNombre());
				}
			}
		});
		
		service.mostrarProvinciasPorCcaa().keySet().forEach(c -> {
			
			service.mostrarProvinciasPorComunidad().keySet().forEach(s -> {
				if(c.equals(s)) {
					System.out.println(c + " y " + s);
				}else {
					System.out.println("No ha entrado en el if");
				}
			
			});
			
		});
		*/
		
		System.out.println(service.mostrarProvinciasPorCcaa().values());
		
		//List<Provincia> provincias = service.mostrarProvinciasP().values();
		
		Map<String, List<Provincia>> provinciasPorComunidad = service.mostrarProvinciasPorCcaa();
		
		// Iterar sobre el mapa para acceder a cada provincia y sus municipios
		for (Map.Entry<String, List<Provincia>> entry : provinciasPorComunidad.entrySet()) {
			String ccaa = entry.getKey();
			List<Provincia> provincias = entry.getValue();
			
			System.out.println("Comunidad Autónoma: " + ccaa);
			System.out.println("        Provincias:");
			
			// Iterar sobre la lista de municipios de la provincia actual
			for (Provincia p : provincias) {
				System.out.println("            - " + p.getNombre());
				
				service.mostrarProvinciasPorComunidad().keySet().forEach(s -> {

					//System.out.println("Sus municipios: ");
					//System.out.println(service.mostrarMunicipiosPorProvincia(s));
					
					
					Map<String, List<Municipio>> municipiosPorProvincia = service.mostrarMunicipiosPorProvincia(s);
					
					// Iterar sobre el mapa para acceder a cada provincia y sus municipios
					for (Map.Entry<String, List<Municipio>> entryMunicipios : municipiosPorProvincia.entrySet()) {
						String provinciaKey = entryMunicipios.getKey();
						if(p.getNombre().equals(provinciaKey)) {
							
							List<Municipio> municipios = entryMunicipios.getValue();
							
							//System.out.println("Provincia: " + provinciaKey);
							System.out.println("                   Municipios:");
							
							// Iterar sobre la lista de municipios de la provincia actual
							for (Municipio municipio : municipios) {
								System.out.println("                        - " + municipio.getNombre());
							}
							
						}
					}
				});
				
			}
		}
	}

}
