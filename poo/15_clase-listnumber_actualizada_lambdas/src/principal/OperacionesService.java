package principal;

import java.util.List;
import java.util.function.Predicate;

public class OperacionesService{

	
	// Además
	// método que recibe una lista de números enteros
	// y devuelve la suma de los múltiplos de 5.
	
	// Uso de la interfaz Predicate

	public int sumaPorCondicion(List<Integer> numeros, Predicate<Integer>condicion) {
		int suma = 0;
		
		for(int n: numeros) {
			if(condicion.test(n)) {
				suma+=n;
			}
		}
		return suma;
	}
}

