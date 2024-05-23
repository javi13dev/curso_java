package pruebas;

enum Orientacion {
	NORTE,SUR,ESTE,OESTE;  // El ; final es opcional.
}

public class Test {

	public static void main(String[] args) {
		Orientacion or = Orientacion.NORTE;
		
		// Este objeto enum se puede meter en un siwtch
		
		switch(or) {
			case NORTE -> System.out.println("norte");
			case SUR -> System.out.println("sur");
		}
		
		// norte
		
		var res = switch(or) {
			case NORTE -> "norte";
			case SUR -> "sur";
			case ESTE -> "este";
			case OESTE -> "oeste";
		};// aqui como son todos los valores posible no hace falta el default.
		
		// norte
	}

}
