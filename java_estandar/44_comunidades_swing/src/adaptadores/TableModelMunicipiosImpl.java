package adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Municipio;
import service.DatosProvinciasServiceFactory;


public class TableModelMunicipiosImpl extends AbstractTableModel {
	
	List<Municipio> municipios;
	
	public TableModelMunicipiosImpl(String provincia) {
		// Creamos este constructor para definir los paises
		var comunidadesService = DatosProvinciasServiceFactory.getDatosProvinciasService();
		municipios = comunidadesService.municipiosComunidad(provincia);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return municipios.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return switch(columnIndex) {
		case 0 -> "Nombre";
		case 1 -> "Poblacion";
		case 2 -> "Altitud";
		case 3 -> "Superficie";
		default -> "";
	};
	}

}
