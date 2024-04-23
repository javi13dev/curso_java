package pruebas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test13Peek {

	public static void main(String[] args) {
	
		List<Integer> nums = new ArrayList<>(List.of(1,2,2,3, -5,3,4,10,20));
		
		// Muestra cada número de la lista y el total de ellos:
		
		System.out.println(
		nums.stream()
		.distinct()
		.peek(n -> System.out.println(n))
		.count());
		
		System.out.println();
		System.out.println("Otro ejercicio:");
		System.out.println();
		
		
		// Muestra cada número de la lista , sin contar duplicados y la suma total de ellos:
		System.out.println(
		nums.stream()
		.peek(n -> System.out.println(n))
		.collect(Collectors.summingInt(n -> n)));
		

	}

}
