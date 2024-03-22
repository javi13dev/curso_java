package principal;

import java.util.Scanner;

public class Solicitud_Pin {

	public static void main(String[] args) {
		//hacer un programa que solicite la introducción de un PIN
		//si es correcto, le muestra un mensaje y el programa termina
		//si es incorrecto, le informa de ello al usuario y le solicita
		//de nuevo el pin. Si falla tres veces en la introducción del pin
		//le muestra mensaje de error, y el programa termina
		Scanner sc=new Scanner(System.in);
		final String PIN_VALIDO="1234"; 
		String pinLeido;
		int intentos=3;
		while(intentos>0) {
			System.out.println("Introduce pin:");
			pinLeido=sc.nextLine();//lectura de dato por teclado
			if(pinLeido.equals(PIN_VALIDO)) {
				System.out.println("Pin correcto!");
				//intentos=0; //para que no vuelva a entrar en while
				break; //ya no necesita seguir pidiendo pin, abandonamos repetitiva
			}else {
				intentos--;
				if(intentos>0) {
					System.out.println("Pin incorrecto, vuelve a intentarlo, te quedan "+intentos+" intentos");
				}else {
					System.out.println("Intruso, no puedes entrar!!!");
				}
			}
		}
		
		
		

	}

}
