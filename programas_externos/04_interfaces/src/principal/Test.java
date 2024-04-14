package principal;

public class Test {

	public static void main(String[] args) {
		Cuadrado cuadrado = new Cuadrado(10);
		
		
		System.out.println("Lado del cuadrado: " + cuadrado.getLado());
		System.out.println("Área del cuadrado " + cuadrado.calcularArea());
		System.out.println("Peímetro del cuadrado " + cuadrado.calcularPerimetro());
	}

}
