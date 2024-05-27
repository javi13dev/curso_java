package pruebas;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections_ejemplos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Errores de compilación?
		
		List<String> lst1=List.of("e","a","x");
		Set<String> st1=new HashSet<>();
		Map<String,String> mp=new HashMap<>();
		Set<String> set2=Set.of(); //l1  Conjunto vacío, no hay error
		st1.add(lst1.get(0)); //l2
		mp.put(null,lst1.get(1));  //l3 Es posile meter claves nulas.
		//set2.add(lst1.get(2));  //l4  Ojo, compila, aunque como un set.of() genera un objeto inmutable, será un error, pero no en compilación.
		
		// Errores de ejecución?
		// l4, porque es inmutable.
		
	}

}
