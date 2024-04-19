package pruebas;

import java.util.ArrayList;
import java.util.List;

public class OrdenarTextos {

	public static void main(String[] args) {
		List<String> cadenas = new ArrayList<>(List.of("primera", "palabra", "add"));
		
		cadenas.sort((a,b)->a.compareTo(b));
		cadenas.forEach(s -> System.out.println(s));
	}

}
