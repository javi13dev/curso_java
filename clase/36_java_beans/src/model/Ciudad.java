package model;

public class Ciudad {
	
	// atributos
	private String nombre;
	private int poblacion;
	private double temperatura;
	
	
	// Constructor
	public Ciudad (String nombre, int poblacion, double temperatura) {
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.temperatura = temperatura;
	}
	public Ciudad () {
	}
	
	// Setters y Getters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	
	public void setTemperatura (int temperatura) {
		this.temperatura = temperatura;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPoblacion() {
		return poblacion;
	}
	
	public double getTemperatura() {
		return temperatura;
	}
	
}
