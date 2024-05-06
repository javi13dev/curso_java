package view;

import java.util.List;

import model.Comunidad;
import model.Municipio;
import model.Provincia;
import service.ComunidadService;
import service.ComunidadesService;
import service.MunicipioService;
import service.ProvinciaService;

public class Comunidades {

	static ComunidadesService service = new ComunidadesService();
	static ComunidadService cService = new ComunidadService();
	static ProvinciaService pService = new ProvinciaService();
	static MunicipioService mService = new MunicipioService();
	
	public static void main(String[] args) {
		
		List<Comunidad> comunidades = service.mostrarComunidades();
		// Para recuperar las comunidades
		comunidades.stream()
		.distinct()
		.forEach(c -> {
			if(cService.comunidadPorId(c.getCodigo())==null) {
				cService.altaComunidad(c);
				
				 List<Provincia> provincias = service.mostrarProvincias(c.getNombre());
				 provincias.stream()
				 .forEach(p -> {
					if(pService.provinciaPorId(p.getCodigo())==null) {
						pService.altaProvincia(p);
						
						List<Municipio> municipios = service.mostrarMunicipios(p.getCodigo());
						municipios.stream()
						.forEach(m -> {
							if(mService.municipioPorId(m.getCodigo())==null) {
								mService.altaMunicipio(m);
							}
						});
					} 
				 });
			}
		});


	}

}
