package view;

import java.util.List;

import inter.InterfazCondicion;
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
	}

}
