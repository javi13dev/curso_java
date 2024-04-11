package service;

/**
    clase CuentaLimite
	Clase que hereda Cuenta. Incorporará un atributo "limite",
	para limitar la extracción a dicho valor.
	Además, añadiremos un método ajustarLimite(), que fijará el límite
	en la mitad del saldo 
 * 
 */
public class CuentaLimite extends Cuenta{
	private double limite;
	
	
	public CuentaLimite(double saldo, double limite) {
		super(saldo);
		this.limite = limite;
	}
	
	public CuentaLimite(double limite) {
		this.limite = limite;
	}
	
	public CuentaLimite() {
		limite = 50; // por defecto cuando no se pasa límite.
	}
	

	@Override
	public void extraer(Double cantidad) {
		if(cantidad < limite) {
			super.extraer(cantidad);			
		}
	}
	
	public void ajustarLimite() {
		limite = obtenerSaldo()/2;
	}
	
	
}
