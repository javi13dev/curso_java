package principal;

import java.util.ArrayList;

/**
 *  Vamos a crear una clase, llamada ListNumber, para
	manejar listas de números enteros.
	La clase, heredará ArrayList<Integer>, e incorporará
	las siguientes mejoras:
	
	-Método first() que devuelve el primer elemento de la lista
	-Método last() que devuelve el último elemento de la lista
	(ambos devuelven null si la lista está vacía)
	-Método sum() que devuelve la suma de todos 
	los elementos de la lista
	
	-No debe permitir añadir números ya existentes
 */

public class ListNumber extends ArrayList<Integer>{

	public Integer first() {
		// -Método first() que devuelve el primer elemento de la lista
		//(ambos devuelven null si la lista está vacía)
		
		/**
			Integer i = (Integer) get(0);
			return i;
		 * 
		 */
		if(size() > 0) {			
			return get(0);
		}else {
			return null;
		}
	}
	
	public Integer last() {
		//-Método last() que devuelve el último elemento de la lista
		//(ambos devuelven null si la lista está vacía)
		
		if(size() > 0) {			
			return get(size() - 1);
		}else {
			return null;
		}
	}
	
	public int sum() {
		//Método sum() que devuelve la suma de todos los elementos de la lista
		
		int sum = 0;
		for(int i = 0; i < size(); i++) {
			sum+=get(i);	
		}
		
		/**
		for(Integer n:this) {
			sum+=n;
		}
		 * 
		 */
		return sum;
	}

	
	// No debe permitir añadir números ya existentes
	
	@Override
	public boolean add(Integer e) {
		
		for(int i = 0; i < size(); i++) {
			if(get(i) == e) {
				return false;
			}
		}
		return super.add(e);
		
		/**
		if(!contains(e)) {
			return super.add(e);
		}
		return false;
		 * 
		 */
	}
	
	
	// Nuevo metodo eliminarNumeros, cualquier grupo de números en base a una condición. 
	
}
