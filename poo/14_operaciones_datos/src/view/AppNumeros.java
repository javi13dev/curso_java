package view;

import java.util.List;

import inter.MiInterfaz;
import service.OperacionesService;

class Pares implements MiInterfaz{
	boolean test (Integer n) {
		if(n%2==0) {
			return true;
		}return false;
	}
}

class Positivos implements MiInterfaz{
	boolean test (Integer n) {
		return n>0;
	}
}

public class AppNumeros {

	public static void main(String[] args) {
		
		List<Integer> numeros = List.of(3,5,80,-2,4,-10,17);
		
		// Teniendo la lógica de negocio del service y la interfaz:
		
		// Imprimir, por una lado, la suma de los pares.
		// Y la suma de los positivos.
		
		// Para eso hay que llamar a operacionesService.
		
		OperacionesService service = new OperacionesService();
		
		Pares pares = new Pares();
		
		/**
		 * 
		for(Integer i : numeros) {
			
			service.sumaPorCondicion(numeros, new Positivos());
		}
		 */
		System.out.println("Suma positivos: "+service.sumarPorCondicion(numeros, new Positivos()));
		System.out.println(service.sumaPorCondicion(numeros, new Positivos());
	}

}
