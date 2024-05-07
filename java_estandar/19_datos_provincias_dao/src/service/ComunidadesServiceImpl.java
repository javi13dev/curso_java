package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.ComunidadesDao;
import dao.ComunidadesDaoFactory;
import dao.MunicipiosDao;
import dao.ProvinciasDao;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

class ComunidadesServiceImpl implements ComunidadesService {

	ComunidadesDao comunidadesDao;
	ProvinciasDao provinciasDao;
	MunicipiosDao municipiosDao;
	
	// Teniendo ya ComunidadesDaoFactory:
	public ComunidadesServiceImpl() {
		comunidadesDao = ComunidadesDaoFactory.getComunidadesDao();
		provinciasDao = ComunidadesDaoFactory.getProvinciasDao();
		municipiosDao = ComunidadesDaoFactory.getMunicipiosDao();
		// Así tenemos las implementaciones, y en el paquete service no tenemos
		// por qué conoces estas otras clases.
		// Normalmente, las clases Dao, no deben ser públicas. Porque son de uso interno del paquete.
	}
	
	@Override
	public int saveComunidades(List<Comunidad> comunidades) {
		
		/* Solucion 1
		int cont = 0;
		
		// Forma de recorrer comunidades una por una y si no existe, se guarda.
		for(Comunidad c:comunidades) {
			if(!comunidadesDao.existComunidad(c.getCodigo())) {
				comunidadesDao.save(c);
				cont++;
			}
		}
		return cont;
		*/
		
		/*
		return (int) comunidades.stream()
		.filter(c -> !comunidadesDao.existComunidad(c.getCodigo()))
		.peek(c -> comunidadesDao.save(c))
		.count();
		*/
		
		// Solución 2
		List<Comunidad> nuevasComunidades = comunidades.stream()
		.filter(c -> !comunidadesDao.existComunidad(c.getCodigo()))
		.toList();
		
		comunidadesDao.save(nuevasComunidades);
		
		return nuevasComunidades.size();
		
	}
	
	@Override
	public int saveProvincias(List<Provincia> provincias) {
		// Así conseguimos sólo un acceso a base de datos, en la petición de códigos
		// y otro en la inserción de la lista.
		List<String> codigos = provinciasDao.findCodigos();	
		
		List<Provincia> nuevasProvincias = provincias.stream()
				.filter(p -> !codigos.contains(p.getCodigo()))
				.toList();
	
		provinciasDao.save(nuevasProvincias);
		return nuevasProvincias.size();
	}
	
	@Override
	public int saveMunicipios(List<Municipio> municipios) {
		List<String> codigos = municipiosDao.findCodigos();	
		
		List<Municipio> nuevosMunicipios = municipios.stream()
				.filter(m -> !codigos.contains(m.getCodigo()))
				.toList();
	
		municipiosDao.save(nuevosMunicipios);
		return nuevosMunicipios.size();
	}
	

	
}
