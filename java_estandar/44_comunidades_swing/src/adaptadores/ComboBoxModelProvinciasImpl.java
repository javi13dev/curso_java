package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Provincia;
import service.DatosProvinciasServiceFactory;

public class ComboBoxModelProvinciasImpl extends DefaultComboBoxModel<String> {
	List<Provincia> provincias;
	
	public ComboBoxModelProvinciasImpl (String comunidad) {
		
		var comunidadesService = DatosProvinciasServiceFactory.getDatosProvinciasService();
		provincias = comunidadesService.provinciasComunidad(comunidad);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return provincias.size();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return provincias.get(index).getCodigoProvincia();
	}


	
	
	

}
