package principal;

import java.util.ArrayList;
import java.util.List;

public class TestReplaceAll {

	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<>(List.of(1,2,5,10,31,40));
		
		// Sirve para sustituir cada elemento después de la operación.
		nums.replaceAll(n -> n/2);
		
		nums.forEach(n->System.out.println(n));
	}

}
