package service;

public class Mesa implements Operaciones{

	// Añadir una nueva clase llamada mesa, con tres atributos, ancho, alto y largo que implemente la interfaz Operaciones
	private int ancho;
	private int alto;
	private int largo;
	
	public Mesa(int ancho, int alto, int largo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.largo = largo;
	}
	
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	@Override
	public void girar(int grados) {
		ancho+=grados;
		alto+=grados;
		largo+=grados;
		
	}
	@Override
	public int invertir() {
		int ejeX = 0;
		return ejeX;
	}
	


}
