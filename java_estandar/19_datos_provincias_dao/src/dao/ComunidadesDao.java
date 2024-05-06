package dao;

import java.util.List;

import model.Comunidad;
import model.Municipio;
import model.Provincia;

public interface ComunidadesDao {
	void saveComunidades(List<Comunidad> comunidades);
	void saveProvincias(List<Provincia> provincias);
	void saveMunicipios(List<Municipio> municipios);
}
