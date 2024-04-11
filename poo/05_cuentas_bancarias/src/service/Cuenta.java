package service;

/**
	Crear una clase llamada Cuenta, que defina operaciones
	sobre una cuenta bancaria.
	La clase tendrá un atributo saldo y los siguientes métodos:
	-ingresar(double cantidad)
	-extraer(double cantidad)
	-obtenerSaldo()
 */

public class Cuenta {

	private double saldo;

	public Cuenta(double saldo) {
		super();
		this.saldo = saldo;
	}

	public Cuenta() {
		saldo=100;
	}
	
	
	public void ingresar(Double cantidad) {
		saldo+=cantidad;
	}
	public void extraer(Double cantidad) {
		saldo-=cantidad;
	}
	public double obtenerSaldo() {
		return saldo;
	}
	
	
}
