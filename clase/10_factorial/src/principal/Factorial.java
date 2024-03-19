package principal;

public class Factorial {

	public static void main(String[] args) {
		// Hallar el factorial:
		// Es el producto del total del número - 1
		
		
		int num = 10;
		int factorial = 1;
		
		/**
		int resultado;
		int suma = 0;
		
		for(int i = 2; i < num ; i++ ) {
			
			resultado = num * (num-1);
			suma = suma + resultado;
			
			System.out.println(resultado);
			System.out.println(suma);
			
		}
		 * 
		 */
		
		for(int i = num; i>=2; i--) {
			factorial = factorial*i;
		}
		
		System.out.println(factorial);
		
		
		
	}
}
