package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Test8MapToDouble {

	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<>(List.of(1,2,2,3, -5,3,4,10,20));
		
		
		
		
		// suma de todos los números negativos
		
		System.out.println(
				nums.stream()
				.filter(n -> n<0)
				.mapToInt(n -> n)
				.sum());


		// media de los positivos, sin duplicados
	
			nums.stream()
			.filter(n -> n>0) // Stream<Integer>
			.distinct()       // Stream<Integer>
			.mapToInt(n -> n) // IntStream
			.average()	      // Optional<Double>
			.ifPresentOrElse(r->System.out.println(r), () -> System.out.println("No hay media"));
			// Primera opción si es Present, y la segunda es el runable.
	}
	
	
}
