package service;

// crear una clase triangulo que herede Figura. Tendrá dos atributos: base y altura.
// Crear una clase Circulo que herede Figura. Tendrá una tributo radio. 

public class Triangulo extends Figura implements Operaciones{
	
	private double base;
	private double altura;
	
	public Triangulo(String color, double base, double altura) {
		super(color);
		this.base = base;
		this.altura = altura;
	}
	
	public double area() {
		return (base*altura)/2;
	}
	
	@Override
	public void girar(int grados) {
		System.out.println("Va a girar " + grados + " grados");
	}
	
	@Override
	public int invertir() {
		int ejeX = 0;
		return ejeX; 
	}

}
