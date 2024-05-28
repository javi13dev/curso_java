package model;

import java.util.List;

public class Bean<T> {
	private T dato;

	public Bean(T dato) {
		this.dato = dato;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public void saveData(List<T> lst) { // Dentro del contexto de esta definición se usa la T
		
	}
	public void print(List<? super T> arg) { // Esta T se refiere al tipo con el que se haya definido. 
		
	}
	
}
