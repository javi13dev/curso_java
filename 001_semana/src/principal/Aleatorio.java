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
					System.out.println(i);
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
	

}
