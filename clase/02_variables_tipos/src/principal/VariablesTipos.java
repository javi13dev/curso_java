package principal;

public class VariablesTipos {

	static int z; // variables de tipo atributo (tienen valor inicial)
	
	public static void main(String[] args) {
		int a, b, c = 10; // variables locales (no tienen valor inicial, hay que inicializarlo para usarlo)
		System.out.println(c);
		System.out.println("Concatenamos el valor "+ c);
		System.out.println(z);
		
		// valores según su tipo
		// * en java los boolean no se pueden igualar a true o false
		
		
		// casos especiales:
		
		int cantidad = 234_233_444;
		// java permite poner el guión entre números para verlo mejor. 
		
		float f = 4.7f; // los literales decimales son doubles si no se pone la f
		long l = 345_345_355_345l;  // los literales enteros son int salvo que se use la l
		
		// pra ver un binario:
		int bin = 0b101;
		
	}

}
