package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Test5 {

	public static void main(String[] args) {
		// Filter
		List<Integer> nums = new ArrayList<>(List.of(1,2,2,3, -5,3,4,10,20));
		
		// ¿Cuántos números positivos no repetidos existen?
		
		System.out.println(nums.stream()
				.distinct()
				.filter(n -> n>0)
				.count());
	
	}
}
