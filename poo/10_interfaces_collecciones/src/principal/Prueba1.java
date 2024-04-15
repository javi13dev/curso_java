package principal;

import java.util.ArrayList;
import java.util.List;

public class Prueba1 {

	public static void main(String[] args) {
		// Crear método que reciba una lista de Integer
		// y devuelva la suma de los pares de dicha lista
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(10);
		lista.add(17);
		lista.add(20);
		
		System.out.println(lista);

		int suma = suma(lista);
		System.out.println(suma);
		// Y valdria para cualquier tipo de lista.
	}

	public static int suma(List<Integer> lista) {
		int suma = 0;
		
		for(Integer i : lista) {
			if(i%2==0) {
				suma+=i;
			}
		}
		return suma;
	}
}
