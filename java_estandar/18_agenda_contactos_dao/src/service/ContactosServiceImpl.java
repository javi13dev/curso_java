package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ContactosDao;
import model.Contacto;

public class ContactosServiceImpl implements ContactosService {
	// Esta va a ser la clase que implemente la interfaz : refactor --> extract Interface
	
	ContactosDao contactosDao;
	// Para tener el objeto de la otra capa preparado para usarlo:
	public ContactosServiceImpl() {
		contactosDao=ContactosDao.of();
	}
	
	// Nuevo contacto:
	@Override
	public boolean nuevoContacto(Contacto contacto) {
		// Vemos así que desde esta capa no tiene por qué tener el acceso a los procesos.
		if(contactosDao.findByEmail(contacto.getEmail())!=null) {
			return false;
		}
		
		contactosDao.save(contacto);
		return true;
	}
	
	
	// Eliminar contacto, devuelve el contacto eliminado.
	// Si no se ha eliminado ninguno, devuelve null.
	@Override
	public Contacto eliminarContacto(String email) {
		Contacto contacto = contactosDao.findByEmail(email);
		if(contacto == null) {
			return null;
		}
		contactosDao.deleteByEmail(email);
		return contacto;
	}
	
	// con método privado:
	@Override
	public Contacto eliminarContactoPrivado(String email) {
		
		Contacto contacto = contactosDao.findByEmail(email);
		if(contacto == null) {
			return null;
		}
		contactosDao.deleteByEmail(email);
		return contacto;
	}
	
	
	
	// Actualizar edad
	@Override
	public boolean actualizarEdad(String email, int edad) {
		Contacto contacto = contactosDao.findByEmail(email);
		if(contacto!=null) {
			contacto.setEdad(edad);
			contactosDao.update(contacto);
			return true;
		}
		return false;
	}
	
	
	
	// Buscar contacto por su clave primaria
	@Override
	public Contacto buscarContactoPorId(int idContacto) {
		
		return contactosDao.findById(idContacto);
	}
	
	
	
	// Recuperar todos los contactos, como una lista
	
	@Override
	public List<Contacto> getContactos(){
		return contactosDao.findAll();
	}

	
}
