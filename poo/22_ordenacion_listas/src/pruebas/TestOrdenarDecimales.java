package pruebas;

import java.util.ArrayList;
import java.util.List;

public class TestOrdenarDecimales {

	public static void main(String[] args) {
		// Ejemplos:
		List<Double> lst = new ArrayList<>(List.of(8.5,2.1,3.4,4.1,4.2,5.0,10.3));
		
		// Para ordenarlos de menos a más , usamos el método sort.
		// Para ello necesita usar compare para saber cuando es negativo o positivo:
		
		// Error porque devuelve un entero
		// Usamos el método propio de la clase Double, compareTo(double, double)
		lst.sort((a,b)->a.compareTo(b));
		lst.forEach(n->System.out.println(n));
		
		// o bien, un método estático de la clase Double, que también recibe dos dobles para comparar.
		lst.sort((a,b)->Double.compare(b, a));
		lst.forEach(n->System.out.println(n));

	}

}
