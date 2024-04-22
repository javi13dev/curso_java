package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Test9Reduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<>(List.of(1,2,2,3, -5,3,4,10,20));
		
		// Suma todos los negativos:
		System.out.println(
				nums.stream()
				.filter(n -> n<0)
				.reduce((a,b) -> a+b)
				.orElse(0)
				);
		// Valora el primer y segundo parámetro.
		// Lo devuelve como optional, por lo que cerramos con un orElse()
	}

}
