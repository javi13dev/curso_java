package service;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
	

	public int sumaPorCondicion(List<Integer> numeros, Predicate<Integer> condicion) {
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
	
	
	
	// Más ejercicios:
	
	//método que recibe una lista de números e imprime los pares
	//método que recibe un conjunto de números y guarda en un fichero los positivos
	//método que recibe una lista y guarda en un fichero los múltiplos de cinco
	//método que recibe un conjunto de números e imprime los negativos 
	
	public void operacion(Collection<Integer> numeros, Predicate<Integer> condicion, Consumer<Integer> op) {
	
		for(Integer n: numeros) {
			if(condicion.test(n)) {
				op.accept(n);
			}
		}
	}
	
	
	
}

