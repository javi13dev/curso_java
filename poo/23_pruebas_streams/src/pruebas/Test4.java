package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		// Comprobaciones, métodos finales:
		// Si encuentra la condición no recorre más.
		
		List<Integer> nums = new ArrayList<>(List.of(1,2,2,3, -5,3,4,10,20));
		
		
		// Hay algún número negativo?
		System.out.println(nums.stream()
							   .anyMatch( n -> n<0));
		
		// Son todos pares?
		System.out.println(nums.stream()
				   			   .allMatch( n -> n%2==0));
		
		
	}

}
