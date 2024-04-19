package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		
		// Métodos intermedios: distinct(), limit(long n), skip(long n)
		List<Integer> nums = new ArrayList<>(List.of(1,2,2,3, -5,3,4,10,20));
		System.out.println(nums.stream().distinct().count());
		
	}
	
}
