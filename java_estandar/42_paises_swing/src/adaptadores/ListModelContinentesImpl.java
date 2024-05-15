package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import service.PaisServiceFactory;

public class ListModelContinentesImpl extends DefaultListModel<String> {
	

	
	List<String> continentes;
	
	// Se instancia el constructor
	public ListModelContinentesImpl() {
		var paisesService = PaisServiceFactory.getPaisService();
		continentes = paisesService.mostrarContinentes();
	}
	// Obtenidos la lista de continentes, se sobreescriben los métodos:

	@Override
	public int getSize() {
		return continentes.size();
	}

	@Override
	public String getElementAt(int index) {
		// Con los mismos métodos de List se pueden determinar la devolución.
		return continentes.get(index);
	}
	
	
	
}
