package principal;

import java.util.ArrayList;
import java.util.List;

public class TestRemoveIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = List.of(1,2,5,10,31,40);
		
		// nums.removeIf(n -> n>3);
		// Error porque no se puede modificar una lista resultante de List.of
		// nums.forEach((n)->System.out.println(n));
		
		// Por tanto:
		List<Integer> lst = new ArrayList<>(List.of(1,2,5,10,31,40));
		lst.removeIf(n -> n>3);
		lst.forEach((n)->System.out.println(n));
	}

}
