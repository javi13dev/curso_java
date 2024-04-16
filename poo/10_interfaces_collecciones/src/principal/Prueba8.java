package principal;

import java.util.List;

public class Prueba8 {

	public static void main(String[] args) {
		// Métodos de factoría.
		// A través de métodos estáticos de interfaces se pueden crear objetos de la clase que implementa la interfaz
		// sin necesidad de crear el objeto.
		
		// Devuelve una lista inmutable
		List<Integer>  nums = List.of(20,30,5,1);
		for(Integer n:nums) {
			System.out.println(n);
		}
	}

}
