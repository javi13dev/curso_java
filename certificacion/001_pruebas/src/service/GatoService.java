package service;

import java.util.List;

import model.Gato;

public interface GatoService {
	
	Gato findGato(String nombre);
	
	List<Gato> listGatos();
	
}
