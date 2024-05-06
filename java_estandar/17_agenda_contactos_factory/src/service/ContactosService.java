package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	// Nuevo contacto:
	boolean nuevoContacto(Contacto contacto);

	boolean nuevoContactoPrivado(Contacto contacto);

	// Eliminar contacto, devuelve el contacto eliminado.
	// Si no se ha eliminado ninguno, devuelve null.
	Contacto eliminarContacto(String email);

	// con método privado:
	Contacto eliminarContactoPrivado(String email);

	// Actualizar edad
	void actualizarEdad(String email, int edad);

	// Buscar contacto por su clave primaria
	Contacto buscarContactoPorId(int idContacto);

	List<Contacto> getContactos();

}