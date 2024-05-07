package dao;

import java.util.List;

import model.Comunidad;
import model.Municipio;
import model.Provincia;

public interface ComunidadesDao {
	void save(List<Comunidad> comunidades);
	void save(Comunidad comunidad);
	boolean existComunidad(String codigo);
}
