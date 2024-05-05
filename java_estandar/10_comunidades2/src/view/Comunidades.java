package view;

import java.util.List;
import java.util.Map;

import model.Municipio;
import model.Provincia;
import service.ComunidadesService;

public class Comunidades {

	static ComunidadesService service = new ComunidadesService();
	
	public static void main(String[] args) {
		
		
		service.mostrarComunidades()
		.forEach(c -> {
			System.out.println("Comunidad Autónoma: " + c);
			service.mostrarProvincias(c)
			.forEach(p -> {
				System.out.println( "		Provincia: " + p.getNombre());
				service.mostrarMunicipios(p.getCodigo())
				.forEach(m -> System.out.println(" 		Municipio: " + m.getNombre()));
			});
		});
		// Para poder recorrerlas uso la interfaz Entry, me daba menos errores:

	}

}
