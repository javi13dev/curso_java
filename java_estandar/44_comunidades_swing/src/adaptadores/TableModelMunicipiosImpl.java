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
	public String getColumnName(int column) {
		return switch(column) {
			case 0 -> "Nombre";
			case 1 -> "Poblacion";
			case 2 -> "Altitud";
			case 3 -> "Superficie";
			default -> "";
		};
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		return switch(column) {
			case 0 -> municipios.get(row).getNombreMunicipio();
			case 1 -> municipios.get(row).getPoblacion();
			case 2 -> municipios.get(row).getAltitud();
			case 3 -> municipios.get(row).getSuperficie();
			default -> "";
		};
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// Obtener el tipo de la columna.
		return switch(columnIndex) {
			case 0 -> String.class;
			case 1 -> Integer.class;
			case 2 -> Integer.class;
			case 3 -> Double.class;
			default -> String.class;
		};
	}
}





