package principal;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Primitiva {
	
	public static void main(String[] args) {
		// introducir una combinación;
		// 6 números separados por una coma.
		// Muestra la combinación introducida
		// Muestra la combinación ganadora
		// E indica cuántos aciertos hemos tenido.
		
		int[] numeros = new int[6];
		int intentos = 6;
		var rnd=new Random();
		
		String combinacion;
		String [] misNumeros;
		int [] miApuesta = new int[6];
		Scanner sc = new Scanner(System.in);
		int contador = 0;
		
		System.out.println("Introduce tu combinación de 6 números de dos cifras separados por comas:");
		combinacion = sc.nextLine();
		misNumeros= combinacion.split(",");
		
		// Aqui guardo los números en un array de enteros
		for(int i=0; i<intentos; i++) {
			miApuesta[i] = Integer.parseInt(misNumeros[i]);
		}

		// para obtener los números de la combinación ganadora
		for(int i=0;i<=intentos-1;i++) {
			int num=rnd.nextInt(49)+1;
			if(comprobar(numeros, num)) {
				numeros[i] = num;
			}else {
				i--;
			}
		}
		Arrays.sort(numeros);
		
		// Mi combinacion:
		
		// Aqui tengo la combinación ganadora:
		
		System.out.println("\nEsta es la combinación ganadora: ");
		for(int i: numeros) {
			System.out.print(i+" ");
		}
		
		System.out.println("\nTu combinación es:");
		for(int n:miApuesta) {
			System.out.print(n +  " ");
			contador = comprobarAciertos(numeros,n, contador);
		}
		System.out.println("\nHas tenido " + contador + " aciertos");
	}
	
	
	static boolean comprobar(int [] numeros, int num) {
		boolean aparece = true;
		for(int n:numeros) {
			if(n == num) {
				aparece = false;
			}
		}
		return aparece;
	}
	
	static int comprobarAciertos(int [] numeros, int num, int contador) {
		for(int n:numeros) {
			if(n == num) {
				contador++;
			}
		}
		return contador;
	}
}
