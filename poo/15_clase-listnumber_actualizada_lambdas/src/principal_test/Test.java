package principal_test;

import principal.ListNumber;
import service.Condicion;
import service.Operacion;


/**
class Impares implements Condicion{
	@Override
	public boolean test(Integer n) {
		if(n%2!=0) {
			return true;
		}return false;
	}
}


class RaizCuadrada implements Operacion{

	@Override
	public Integer test(Integer n) {

		return (int)Math.sqrt(n);
	}
	
}
*/

public class Test {

	public static void main(String[] args) {
		ListNumber lista = new ListNumber();
		
		lista.add(20);
		lista.add(40);
		lista.add(60);
		lista.add(11);
		lista.add(30);
		lista.add(17);
		lista.add(20);
		
		//lista.eliminarNumeros(new Impares());
		lista.eliminarNumeros(n -> n%2!=0);
		//lista.transformarNumeros(new RaizCuadrada());
		lista.transformarNumeros( n -> (int)Math.sqrt(n));
		
		System.out.println();
		System.out.println(lista.first());
		System.out.println(lista.last());
		System.out.println(lista.sum());
		
		
		
	}
}
