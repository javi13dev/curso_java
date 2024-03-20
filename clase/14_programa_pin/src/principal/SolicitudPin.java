package principal;
import java.util.Scanner;

public class SolicitudPin {

	public static void main(String[] args) {
		// Programa que solicite la introducción de un pin
		// Se muestra mensaje si es correcto o no
		// Si falla tres veces se muestra mensaje error y el programa termina
		
		Scanner sc = new Scanner(System.in);
		
		final int PIN = 1234;
		int num;
		int intentos = 3;
		

		while(intentos > 0) {
			System.out.println("Ingrese número pin:");
			num = sc.nextInt();
			if(num != PIN) {
				intentos--;
				if(intentos >0) {
					System.out.println("número pin incorrecto. quedan " + intentos + " intentos.");					
				}else {
					System.out.println("Número pin incorrecto, 0 intentos, fin programa");
				}
			}else {
				System.out.println("número pin correcto");
				break;
			}
		}
	}
}
