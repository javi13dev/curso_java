package service;

import java.util.List;

import inter.InterfazCondicion;

public class OperacionesService{
	// método que recibe una lista de números enteros, y devuelve la suma de los pares.
	/**
	 * 
	public int sumaPares(List<Integer> lista) {
		int suma = 0;
		
		for(int i: lista) {
			if(i%2==0) {
				suma+=i;
			}
		}
		return suma;
	}

	 */
	
	// A continuación:
	// Método que recibe una lista de números enteros y devuelve la suma de los positivos.
	
	/**
	 * 
	public int positivos(List<Integer> lista) {
		int suma = 0;
		for(int i: lista) {
			if(i>0) {
				suma+=i;
			}
		}
		return suma;
	}

	 */
	
	// Además
	// método que recibe una lista de números enteros
	// y devuelve la suma de los múltiplos de 5.
	

	public int sumaPorCondicion(List<Integer> numeros, InterfazCondicion condicion) {
		int suma = 0;
		
		for(int n: numeros) {
			if(condicion.test(n)) {
				suma+=n;
			}
		}
		return suma;
	}
	// Así define que la condición la decidirá quien llame al método.
	// Así vemos que se pueden pasar interfaces como parámetros. Pudiendo hacer flexibles los métodos.
	
}

