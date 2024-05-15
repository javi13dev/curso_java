package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.DatosProvinciasServiceFactory;

public class ComboBoxModelComunidadesImpl extends DefaultComboBoxModel<String> {

	List<String> comunidades;
	
	// Se instancia el constructor
	public ComboBoxModelComunidadesImpl() {
		var comunidadesService = DatosProvinciasServiceFactory.getDatosProvinciasService();
		comunidades = comunidadesService.comunidades();
	}
	// Obtenidos la lista de continentes, se sobreescriben los métodos:

	@Override
	public int getSize() {
		return comunidades.size();
	}

	@Override
	public String getElementAt(int index) {
		// Con los mismos métodos de List se pueden determinar la devolución.
		return comunidades.get(index);
	}
}
