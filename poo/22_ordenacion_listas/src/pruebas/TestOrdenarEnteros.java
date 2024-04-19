package pruebas;

import java.util.ArrayList;
import java.util.List;

public class TestOrdenarEnteros {

	public static void main(String[] args) {
		// Ejemplos:
		List<Integer> lst = new ArrayList<>(List.of(8,2,3,4,5,10));
		
		// Para ordenarlos de menos a más , usamos el método sort.
		// Para ello necesita usar compare para saber cuando es negativo o positivo:
		
		// Criterio, sabiendo que son números enteros, los restamos.
		lst.sort((a,b)->a-b);
		lst.forEach(n->System.out.println(n));
		
		// Si quiero ordenarlo al revés, se cambia el criterio:
		// Le daremos como positivo cuando el primero sea menor.
		lst.sort((a,b)->b-a);
		lst.forEach(n->System.out.println(n));
		

	}

}
