package principal;

import java.util.Arrays;
import java.util.Random;

public class Aleatorio {

	// Ejercicio loteria

	// 6 números aleatorios diferentes del 1 al 49
	// orenados de mayor a menor
	
	
	public static void main(String[] args) {
			
			int[] numeros = new int[6];
			int intentos = 6;
			var rnd=new Random();
			
			for(int i=0;i<=intentos-1;i++) {
				int num=rnd.nextInt(49)+1;
				// Números aleatorios del 1 al 49
				if(comprobar(numeros, num)) {
					// Si no contiene el número, lo añade
					numeros[i] = num;
				}else {
					// Si lo contiene resta uno al iterador para intentar ingresar un número diferente
					i--;
				}
			}
			
			Arrays.sort(numeros);
			for(int i: numeros) {
				System.out.print(i+" ");
			}
	}
	
	
	static boolean comprobar(int [] numeros, int num) {
		boolean aparece = true;
		for(int n:numeros) {
			if(n == num) {
				System.out.println("coinciden");
				aparece = false;
			}
		}
		return aparece;
	}
	
	
	/**
	 * 
	public static void main(String[] args) {
		
		int[] generados = new int[6];
		int numero, totales=0;
		
		do {
			numero=(int)Math.random()*49+1;
			if(repetido(generados,numero,totales) == false) {
				// generado un número, si no está repetido, se guarda, mientras no llevemos 6
				generados[totales] = numero;
				totales++;
			}
		}while(totales<6);
		
		Arrays.sort(numeros);
		for(int i: numeros) {
			System.out.println(i);
		}
	}
	
	static boolean repetido(int [] numeros, int num, int total) {
		boolean aparece = true;
		for(int i=0; i<total;i++) {
			if(numeros[i]==num) {
				aparece = true;
				break;
			}
		}
		return aparece;
	}

	 */

}
