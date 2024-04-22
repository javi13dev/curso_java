package pruebas;

import java.util.List;

public class Test7Map {

	public static void main(String[] args) {
		List<String> cads = List.of("Cadena", "seg", "ter", "hola");
		// programa que muestre las longitudes de todas las cadenas sin repetir longitudes.
		
		// sabiendo que quiero trabajar con números, primero transformo ese stream de strings en stream de números:
		
		cads.stream() // Stream<String>
		.map( n -> n.length()) // Stream<Integer>
		.distinct()
		.forEach(System.out::println);
	}
}



