package service;

import java.util.List;

import dao.GatosDao;
import dao.GatosDaoFactory;
import model.Gato;

public class GatoServiceImpl implements GatoService{
	
	GatosDao service;
	
	public GatoServiceImpl() {
		service = GatosDaoFactory.getGatosDato();
	}
	
	@Override
	public Gato findGato(String nombre) {
		// Teniendo en cuenta que desde un supuesto Dao 
		// recuperaríamos la info de gatos de la bbdd
		if(service.findGato(nombre) == null) {
			return null;
		}
		
		if(nombre.equals(service.findGato(nombre).getNombre())) {
			return new Gato((service.findGato(nombre).getNombre()), (service.findGato(nombre).getPeso()));
		}
		return null;
	}

	@Override
	public List<Gato> listGatos() {
		return service.listGatos();
	}
	 
	
}
