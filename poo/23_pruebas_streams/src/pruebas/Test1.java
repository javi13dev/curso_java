package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>(List.of(1,2, -5,3,4,10,20));
		
		System.out.println(nums.stream().count());
		
		nums.stream().forEach(System.out::println);
	}

}
