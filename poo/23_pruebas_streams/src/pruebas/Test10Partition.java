package pruebas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test10Partition {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>(List.of(1,2,2,3, -5,3,4,10,20));
		
		// Crear una tabla donde estén agrupados los negativos por un lado
		// y los positivos por otro.
		
		Map<Boolean, List<Integer>> tabla = nums.stream()
		.collect(Collectors.partitioningBy(n -> n>0));
		
		System.out.println(tabla.values());
		
		
		// Ahora la suma de cada grupo, por una lado los negativos, por otro los positivos:
		Map<Boolean, Integer> tabla2 = nums.stream()
		.collect(Collectors.partitioningBy(n -> n>0, Collectors.summingInt(n -> n)));
		
		System.out.println(tabla2.values());

	}

}
