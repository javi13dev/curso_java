package principal;

import java.util.List;

public class TestForEach {

	public static void main(String[] args) {
		List<Integer> lst = List.of(1,2,10,30);
		
		// Programación funcional
		lst.forEach((n)->System.out.println(n+1));
		

	}

}
