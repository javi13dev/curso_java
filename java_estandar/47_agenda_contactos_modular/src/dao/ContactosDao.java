package dao;

import java.util.List;

import model.Contacto;

public interface ContactosDao {
	// Se trata de aislar en esta capa dao independiente,
	// las operaciones básicas, simples de acceso a datos.
	
	void save(Contacto contacto);
	Contacto findByEmail(String email);
	void update(Contacto contacto);
	Contacto findById(int idContacto);
	List<Contacto> findAll();
	void deleteByEmail(String email);
	
	
	// Y vamos a crear la clase para su implementación:
	// ContactosDaoImpl
	
	// 3) se puede aplicar el patrón factory
	static ContactosDao of() {
		return new ContactosDaoImpl();
	}
}
