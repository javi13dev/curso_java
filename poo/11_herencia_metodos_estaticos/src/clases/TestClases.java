package clases;

class C1{
	static void print() {
		System.out.println("c1");
	}
}

class C2 extends C1{
	
}

public class TestClases {

	public static void main(String[] args) {
		// Se heredan los métodos estáticos?, Sí.
		
		// Por lo que podría llamar a la clase-hija.print
		
		C2.print();

	}

}
