package interfaces;

interface I1 {
	static void print() {
		System.out.println("I1");
	}
}

class C1 implements I1 {
	
}

interface I2 extends I1 {
	// La interfaz hija NO hereda tampoco.
}

public class TestInterfaces {

	public static void main(String[] args) {
		// En este caso NO hereda el método estático.
		
		// No se puede hacer:
		// C.print();
		
		// Los métodos estáticos de la interfaz son de uso exclusivo. Sí podrían usarse instanciando la interfaz.
		I1.print();

		// Todos los métodos estáticos de las interfaces, >>>>>>>>crean objetos que implementan dicha interfaz.
		// Implementaciones de la interfaz, sin necesidad de crear clases que implementen la interfaz.
		// * Son también denominados métodos de factoría.
		
		// Ej: static <T> Comparator<T>
		
		
	}

}
