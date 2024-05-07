package dao;

import java.util.List;

import model.Provincia;

public interface ProvinciasDao {
	void save(List<Provincia> provincias);
	
	// el método existComunidad no es eficiente porque tiene que comprobar una a una.
	// Asique lo cambiamos:
	// boolean existProvincia(String codigo);
	
	// Vamos a obtener los códigos
	List<String> findCodigos();
}
