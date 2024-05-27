package pruebas;

import java.util.Collections;
import java.util.List;

public class Pregunta_8 {
	
	public static void main(String[] args) {
		var numA = new Integer[] {1,null,3};
		var list1 = List.of(numA);
		var list2 = Collections.unmodifiableCollection(list1);
		numA[1] = 2;
		System.out.println(list1 + " "+ list2);
	}
}
