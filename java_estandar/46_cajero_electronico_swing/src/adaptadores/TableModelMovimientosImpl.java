package adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Movimiento;
import service.CajeroService;
import service.CajeroServiceFactory;

public class TableModelMovimientosImpl extends AbstractTableModel {
	// Necesito los movimientos:
	
	List<Movimiento> movimientos;
	
	public TableModelMovimientosImpl(int idCuenta) {
		CajeroService cajeroService= CajeroServiceFactory.getCajeroService();
		movimientos = cajeroService.obtenerMovimientos(idCuenta);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return movimientos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		return switch(column) {
			case 0 -> "Operacion";
			case 1 -> "Cantidad";
			case 2 -> "Fecha";
			default -> "";
		};
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		return switch(column) {
			case 0-> movimientos.get(row).getOperacion();
			case 1-> movimientos.get(row).getCantidad();
			case 2-> movimientos.get(row).getFecha();
			default -> "";
		};
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// Obtener el tipo de la columna.
		return switch(columnIndex) {
			case 0-> Integer.class;
			case 1-> Double.class;
			case 2-> String.class;
	
			default->String.class;
		};
	}
}
