package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		int [] nums = {7,2,9,0};
		
		Arrays.sort(nums); // No devuelve nada. Lo deja ordenado.
		
		Arrays.stream(nums).forEach(n -> System.out.println(n));
		
		
		
		
		
		// >>>>>>>>> Ordenación de colecciones:
		List<Integer> lst1 = new ArrayList<>(List.of(4,11,2,8,5));
		
		// Tenemos un método sort en Collections:
		Collections.sort(lst1);
		
		System.out.println(lst1);

	}

}
