package dao;

import java.util.List;

import model.Gato;

public interface GatosDao {
	
	Gato findGato(String name);
	List<Gato> listGatos();
	void deleteGato(String nombre);
	void updateGato(String nombre, int peso);
}
