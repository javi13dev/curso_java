package service;

// crear una clase triangulo que herede Figura. Tendrá dos atributos: base y altura.
// Crear una clase Circulo que herede Figura. Tendrá una tributo radio. 

public class Circulo extends Figura{
	
	private double radio;
	
	public Circulo(String color, double radio) {
		super(color);
		this.radio = radio;
	}
	
	public double area() {
		return Math.PI*(radio*radio);
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

}
