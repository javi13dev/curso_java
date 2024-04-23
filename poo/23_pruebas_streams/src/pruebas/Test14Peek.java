package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Test14Peek {

	public static void main(String[] args) {
		
		List<Integer> nums = List.of(1,2,2,3, -5,3,4,10,20);
		
		// otro uso de métodos intermedios:
		// funcionan en modo lazy, es decir, lo que hacen se realiza en memoria.
		
		// que muestre si hay algún negativo:
		System.out.println("negativos?: "+
		nums.stream()
		.peek(n->System.out.println(n))
		.anyMatch(n->n<0)
		);
		
		
		
		
	}

}
