package principal;

public class Cuadrado implements Figura{

	private double lado;



	public Cuadrado(double lado) {
		super();
		this.lado = lado;
	}
	
	// Hay que sobreescribir los métodos
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public double calcularArea() {
		return lado * lado;
	}

	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return 4 * lado;
	}

}
