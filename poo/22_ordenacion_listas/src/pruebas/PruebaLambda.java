package pruebas;

import java.util.function.Consumer;

public class PruebaLambda {

	// Variables de clase sí son posibles usarlas:
	// Ej:
	public static int s = 1;
	
	public static void main(String[] args) {
		// Lambdas
		// No se pueden usar variables locales, a menos que sean constantes efectivas.
		// Permite el uso de constantes o constantes efectivas, es decir,
		// variables que no cambien de valor.
		
		// Ej:
		int a = 2;
		
		// a++; 
		// Si la variable a se modifica generará un error en el desarrollo de la expresión lambda.
		Consumer<Integer> cons = x -> System.out.println(x+a+s);
		s++;
	}
}
