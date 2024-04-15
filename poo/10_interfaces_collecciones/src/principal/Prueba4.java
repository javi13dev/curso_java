package principal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Prueba4 {

	// Realizar un método que recibe dos collecciones de enteros.
	// y devuelve un conjunto con los números contenidos en ambas colecciones
	public static void main(String[] args) {
		//
		
		HashSet<Integer> c1 = new HashSet<>();
		c1.add(1);
		c1.add(2);
		c1.add(6);
		c1.add(4);
		c1.add(5);
		
		HashSet<Integer> c2 = new HashSet<>();
		c2.add(6);
		c2.add(7);
		c2.add(8);
		c2.add(5);
		c2.add(10);
		
		System.out.println(mostrar(c1,c2));
			
		
		HashSet<Integer> todos = new HashSet<>();
		// Aqui guardamos ambas collecciones en una y lo implementamos en un objeto
		todos = (HashSet<Integer>) mostrar(c1,c2);
		
		for(Integer i: todos) {
			System.out.println(i);
		}
		
		// probando iterator para recorrer:
		Set<Integer> resultado = mostrar(c1,c2);
		Iterator<Integer> it = resultado.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static Set<Integer> mostrar (Collection<Integer> c1, Collection<Integer> c2){
		Set<Integer> conjunto = new HashSet<>();
		
		// conjunto.addAll(c1);
		// conjunto.addAll(c2);
		
		for(Integer n:c1) {
			if(c2.contains(n)) {
				conjunto.add(n);
			}
		}
		return conjunto;
	}
}
