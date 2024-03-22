package principal;
import java.util.Scanner;

public class InvertirTexto {

	public static void main(String[] args) {
		
		// solicita la introducción de un texto
		// y lo muestra invertido:
		
		// Tendremos un método invertir y te lo devuelve invertido
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Escribe una palabra:");

		String palabra = sc.nextLine();
		String [] entrada = palabra.split("");
		
		System.out.println(invertir(entrada));
		System.out.println(invertir_profe(palabra));

	}

	static String invertir(String [] texto) {
		
		StringBuilder nuevo_texto = new StringBuilder("");
		int indice = texto.length;
		
		for(int i = 0; i < texto.length; i++) {
			indice--;
			nuevo_texto.append(texto[indice]);
		}
		return nuevo_texto.toString();
	}
	
	static String invertir_profe(String texto) {
		StringBuilder sb = new StringBuilder("");
		for(int i =texto.length() -1; i >=0; i--) {
			sb.append(texto.charAt(i));
		}
		return sb.toString();
	}
}
