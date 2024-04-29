package view;

import java.util.List;
import java.util.Map;

import model.Municipio;
import model.Provincia;
import service.ComunidadesService;

public class Comunidades {

	static ComunidadesService service = new ComunidadesService();
	
	public static void main(String[] args) {

		// Para poder recorrerlas uso la interfaz Entry, me daba menos errores:
		
		Map<String, List<Provincia>> provinciasPorComunidad = service.mostrarProvinciasPorCcaa();
		
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
		}
	}

}
