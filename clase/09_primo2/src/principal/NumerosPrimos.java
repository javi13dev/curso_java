package principal;
import java.util.Scanner;

public class NumerosPrimos {
	// Por teclado
	public static void main (String[] args) {
		boolean esPrimo = true;
		
		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("introduce un número:");
		num = sc.nextInt();		
		
		for(int i = 2; i<num; i++) {
			// La idea es si encuentra un numero divisible no será primo
			
			if(num%i==0) {
				esPrimo = false;
				System.out.println("prueba otro número:");
				num = sc.nextInt();	
			}
		}
		
		System.out.println("El número "+num+ ((esPrimo == true) ? " es primo" : " no es primo"));
		
	}

}
