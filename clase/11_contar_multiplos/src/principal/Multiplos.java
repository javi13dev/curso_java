package principal;
import java.util.Scanner;

public class Multiplos {

	public static void main(String[] args) {
		
		// programa que solicite dos números y nos diga cuántos 
		// múltiplos de 5 hay entre ambos
		// si alguno de los números negativo se vuelve a pedir
		Scanner sc = new Scanner(System.in);
		
		int n1;
		int n2;
		int contador = 0;
		
		do {
			System.out.println("introduce un número:");
			n1 = sc.nextInt();
		}while(n1<0);
		
		do {
			System.out.println("introduce otro número:");
			n2 = sc.nextInt();			
		}while(n2<0);
		
		int mayor = 0;
		int menor = 0;
		
		if(n1>n2) {
			mayor = n1;
			menor = n2;
		}else {
			mayor = n2;
			menor = n1;
		}
		
		for(int i=menor; i<mayor; i++) {
			if(i%5==0) {
				contador++;
				System.out.println(i);
			}
		}
		System.out.println("hay "+ contador + " múltiplos de 5 entre "+ mayor + " y " + menor);
	
	}
}
