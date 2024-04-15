package principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Prueba2 {

	public static void main(String[] args) {
		// Crear método que reciba una colección de Integer
		// y devuelva la media de los valores de dicha colleción
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(10);
		lista.add(30);
		lista.add(20);
		
		System.out.println(lista);

		int media = media(lista);
		System.out.println(media);
		// Y valdria para cualquier tipo de colleción.
		
		HashSet<Integer> nueva_lista = new HashSet<>();
		nueva_lista.add(5);
		nueva_lista.add(10);
		nueva_lista.add(20);
		nueva_lista.add(25);
		
		System.out.println(media(nueva_lista));
		
	}

	public static int media(Collection<Integer> lista) {
		int suma = 0;
		for(Integer i : lista) {
			suma+=i;
		}
		return suma/lista.size();
	}
}
