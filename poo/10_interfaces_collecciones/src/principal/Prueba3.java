package principal;

import java.util.ArrayList;
import java.util.List;

public class Prueba3 {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(11);
		nums.add(6);
		nums.add(12);
		nums.add(19);
		nums.add(11);
		nums.add(11);
		nums.add(40);
		nums.add(21);
		
		List<Integer> sublista = nums.subList(3, 7);
		
	
		for(Integer n:sublista) {
			System.out.println(n);
		}
		
		System.out.println(sublista.getClass().getSimpleName());
	
	}

}
