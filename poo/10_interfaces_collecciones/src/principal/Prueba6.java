package principal;

import java.util.ArrayList;
import java.util.List;

public class Prueba6 {

	public static void main(String[] args) {
		List<Integer> lst1 = new ArrayList<Integer>();
		// En una variable interfaz puedo meter objetos de las clases que la implementan.
		
		// Esto no sería posible, aunque haya herencia entre Number e Integer. Deben ser del mismo tipo.
		// List<Number> lst2 = new ArrayList<Integer>();
		List<Number> lst2 = new ArrayList<Number>();
		
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(20);
		nums.add(10);
		
		// Se podria declarar una lista comodín, admite lista de cualquier tipo.
		List<?> lst5 = nums;
		// El comodín se puede combinar con extends, de forma que puede restringir el tipo
		// Por tanto acepta nums porque Integer hereda de Number.
		List<? extends Number> lst6 = nums;
		
		// también puede combinarse con super, admitiendo en ese caso objetos Integer y su superclase Number.
		List<? super Integer> lst7 = nums;
	}
}
