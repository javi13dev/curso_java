package principal;

import java.util.ArrayList;
import java.util.Iterator;

import service.Condicion;
import service.Operacion;

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
	
	public void eliminarNumeros(Condicion condicion) {
		
		/**
		 * 
		for(Integer n:this) {
			if(condicion.test(n)) {
				remove(n);
			}
		}
		 */
		
		/**
		 * 
		for(int i = 0; i < size(); i++) {
			if(condicion.test(get(i))) {
				remove(i);
			}
		}
		 */
		
		// Eliminar recorriendo un for puede dar problemas, 
		// en este caso ConcurrentModificationException
		
		// Lo mejor seria recorrer con un for pero del final al inicio,
		// o mejor, usando iterator.
		
		Iterator<Integer> it = iterator();
		while(it.hasNext()) {
			if(condicion.test(it.next())) { //Si cumple la condicion, Primero se llama a next para moverlo al siguiente
				it.remove(); // Y eliminarlo, así se hace de forma segura.				
			} 
		}
	}
	
	// Método para transformar cada número de la lista en otro.
	// Debería ser capaz de transformar cada número en su cuadrado, en la mitad, 
	// en su ráiz cúbica, etc.
	
	public void transformarNumeros(Operacion operacion) {
		
		for(int i = 0; i < size(); i++) {
			set(i, operacion.test(get(i)));
			//i =  operacion.test(get(i));
		}
		
		
	}





	
}
