package tests;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		/*
		La clase Arrays proporciona el siguiente método para 
		realizar una búsqueda en un array: 
		
		 int binarySearch(tipo[] array, tipo valor). Devuelve la posición del valor dentro 
		del array, que previamente debe estar ordenado 
		
		Consideraciones sobre el método:
		 
		Si el array no está ordenado, el resultado es impredecible 
		 Si el array está ordenado y el elemento no se encuentra, se devuelve -pIns-1. 
		Donde pIns es la posición que le correspondería al elemento 
		 
		 
		 
		int [] a1= {3,5,7,9,15,20};
		System.out.println(Arrays.binarySearch(a1, 9)); //3
		System.out.println(Arrays.binarySearch(a1, 10)); //-5

		 */
		
		
		// 
		
		List<Integer> lst1 = List.of(11,7,4,2);
		System.out.println(Collections.binarySearch(lst1, 4)); // Inesperado porque no está ordenado.
		System.out.println(Collections.binarySearch(lst1, 4, Comparator.reverseOrder())); // 2
		// En el tercer parámetro le pasamos un criterio.
		// No es error de ordenación, porque BinarySearch no ordena, no modifica la List.

	}

}
