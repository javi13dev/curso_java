package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Movimiento;
/**
 * 
    Clase CuentaMovimientos
	Clase que hereda CuentaLimite. Incopora un nuevo método obtenerMovimientos
	que devolverá un ArrayList con los movimientos realizados
	en la cuenta
	Cada movimiento se define por: cantidad, fechaHora, tipo (ingreso o extracción) 
 */


public class CuentaMovimientos extends CuentaLimite {
	/**
	 * 
	    Clase CuentaMovimientos
		Clase que hereda CuentaLimite. Incopora un nuevo método obtenerMovimientos
		que devolverá un ArrayList con los movimientos realizados en la cuenta.
		Cada movimiento se define por: cantidad, fechaHora, tipo (ingreso o extracción) 
	 */
	
	private ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	
	
	
	public CuentaMovimientos(double saldo, double limite) {
		super(saldo, limite);
	}

	public ArrayList<Movimiento> obtenerMovimientos(){
		return movimientos;
	}
	
	
	@Override
	public void extraer(Double cantidad) {
		Movimiento mov = new Movimiento(cantidad, LocalDateTime.now(), "extraccion");
		movimientos.add(mov);
		super.extraer(cantidad); // es necesario la llamada para que se ejecute la extracción
	}


	@Override
	public void ingresar(Double cantidad) {
		Movimiento mov = new Movimiento(cantidad, LocalDateTime.now(), "ingreso");
		movimientos.add(mov);
		super.extraer(cantidad);
	} 

}
