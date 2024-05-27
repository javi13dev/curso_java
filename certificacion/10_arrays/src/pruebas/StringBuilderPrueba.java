package pruebas;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class StringBuilderPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder [] sbs = new StringBuilder[] {new StringBuilder("hello"),new StringBuilder("todos")};
		List<StringBuilder> lst1 = List.of(sbs);
		lst1.get(0).append("by");
		System.out.println(lst1); // [helloby, todos]
		
		// Lo que es inmutable es la lista, no los objetos de ella.
		// En este caso estamos modificando el primer objeto de la lista, no la lista.
		
		
		// Pregunta 20
		
		Collection<Number> col = new HashSet<>();
		col.add(1);
		var list1 = List.of(col);
		col.add(2);
		var list2 = List.copyOf(col);
		System.out.println(list1 + " " + list2); // [[1, 2]] [1, 2]
	}

}
