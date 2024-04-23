package pruebas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test12FlatMap {

	public static void main(String[] args) {
		// prueba flatMap
		
		/**
		 * List<List<String>> datos=Arrays.asList(Arrays.asList("Gema","María","Carlos"),
			 										Arrays.asList ("Laura","Ana","Luis"));
			 
			System.out.println(datos.stream()
			.flatMap(l->l.stream().map(s->s.length()))
			.filter(n->n>4)
			.count())
		 */
		
		
		// 
		List<Integer[]> nums = List.of(new Integer[] {3,7,5,2,9},
										new Integer[] {8,3,4},
										new Integer[] {9,2,5,6,1,4,8},
										new Integer[] {7,5,4});
		
		// Nota media de todos los alumnos del centro:
		
		// Se utiliza flatMap, para que de cada array me genere un stream
		System.out.println(
			nums.stream() // Stream<Integer[]>
			.flatMap( n -> Arrays.stream(n)) // Stream<Integer>
			.collect(Collectors.averagingInt(n->n))
		);

		
		
	}
}
