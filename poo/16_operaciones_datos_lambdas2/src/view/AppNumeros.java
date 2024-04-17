package view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.function.Predicate;

import service.OperacionesService;
/**
class Pares implements InterfazCondicion{
	@Override
	public boolean test(Integer n) {
		if(n%2==0) {
			return true;
		}return false;
	}
}

class Positivos implements InterfazCondicion{
	@Override
	public boolean test(Integer n) {
		return n>0;
	}
}
*/

public class AppNumeros {

	public static void main(String[] args) {
		
		List<Integer> numeros = List.of(3,5,80,-2,4,-10,17);
		
		// Vamos a simplificar con lambdas
		
		OperacionesService service = new OperacionesService();
		// Donde se usan, donde vayamos a usar la llamada al objeto
		System.out.println("Suma positivos: "+service.sumaPorCondicion(numeros, n->n>0));
		System.out.println("Suma pares: "+service.sumaPorCondicion(numeros, n->n%2==0));
		
		// O bien si me intersa:
		// InterfazCondicion pares = n->n>0;
		// para después usarla.
		// System.out.println("Suma positivos: "+service.sumaPorCondicion(numeros, pares));
		
		// Ejercicio:
		// Suma los negativos mayores que -5:
		System.out.println("Otra: " + service.sumaPorCondicion(numeros, n->n<0 && n>-5));
		
		// Otra posibilidad, sería, guardar en una variable, una de las condiciones:
		Predicate<Integer> negativo = n->n<0;
		// Dada una condición, se pueden usar métodos como:
		System.out.println("Otra: " + service.sumaPorCondicion(numeros, negativo.and(n-> n<-5)));
		
		
		
		//método que recibe una lista de números e imprime los pares
		Predicate<Integer> pares = n->n%2==0;
		System.out.println("Ultimo ejercicio: ");
		service.operacion(numeros, pares, n->System.out.println(n));
		
		
		
		//método que recibe una lista de números e imprime los positivos
		System.out.println("Ultimo ejercicio positivos: ");
		service.operacion(numeros, n -> n>0 , n->System.out.println(n));
		
		//método que recibe una lista de números y guarde los datos en un fichero
		System.out.println("Guardar en fichero: ");
		String ruta="dias.txt";
		service.operacion(numeros, n -> n>0 , n->{
			try {
				FileOutputStream fos=new FileOutputStream(ruta, true);
				PrintStream out= new PrintStream(fos);
				out.println(n);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		});
		
		
		
		// método que recibe una lista y devuelve la suma de todos los elementos de la lista, 
		// añadiendo el valor que se extraiga de un fichero.
		// método que recibe una lista y devuelve la suma de todos los elementos de la lista, 
		// a le añadimos un número léido desde un puerto externo.
		
		
		
	}
}

