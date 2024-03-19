package principal;

public class NumerosPrimos {
	public static void main (String[] args) {
		// Indicará si el número es o no primo
		
		int num = 16;
		boolean esPrimo = true;
		
		for(int i = 2; i<num; i++) {
			// La idea es si encuentra un numero divisible no será primo
			
			if(num%i==0) {
				esPrimo = false;
				System.out.println("no es primo");
			}
		}
		
		System.out.println("El número "+num+ ((esPrimo == true) ? " es primo" : " no es primo"));
		
	}

}
