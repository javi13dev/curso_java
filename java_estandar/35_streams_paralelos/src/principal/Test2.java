package principal;

import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		
		// Muestra los positivos sin duplicados
		
		List<Integer> nums = List.of(5,11,4,-22,3,11,5,9,4,6,-3,3,-8);
		
		nums.parallelStream() // Se ejecutan en orden diferente, porque son tareas separadas.
		.distinct()
		.filter(n -> n>0)
		.sequential() // Método que devuelve el stream pero en monotarea. Las anteriores tareas más pesadas se han relizado en multihilo.
		.forEach(System.out::println);

	}

}
