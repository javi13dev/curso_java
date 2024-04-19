package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		
		/**
			Stream<T> limit(long n). Devuelve un nuevo Stream con 
			los n primeros elementos del mismo.
			Stream<T> skip(long n). Devuelve un nuevo Stream, 
			saltándose los n primeros elementos.
		 * 
		 */
		
		// Ej: imprimer los 5 primeros números sin incluir repetidos:
		List<Integer> nums = new ArrayList<>(List.of(1,2,2,3, -5,3,4,10,20));
		
		nums.stream()
		.distinct()
		.limit(5)
		.forEach(System.out::println);

	}

}
