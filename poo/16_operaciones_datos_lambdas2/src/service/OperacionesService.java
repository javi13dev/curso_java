package service;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OperacionesService{
	// método que recibe una lista de números enteros, y devuelve la suma de los pares.
	/**
	 * 
	public int sumaPares(List<Integer> lista) {
		int suma = 0;
		
		for(int i: lista) {
			if(i%2==0) {
				suma+=i;
			}
		}
		return suma;
	}

	 */
	
	// A continuación:
	// Método que recibe una lista de números enteros y devuelve la suma de los positivos.
	
	/**
	 * 
	public int positivos(List<Integer> lista) {
		int suma = 0;
		for(int i: lista) {
			if(i>0) {
				suma+=i;
			}
		}
		return suma;
	}

	 */
	
	// Además
	// método que recibe una lista de números enteros
	// y devuelve la suma de los múltiplos de 5.
	

	public int sumaPorCondicion(List<Integer> numeros, Predicate<Integer> condicion) {
		int suma = 0;
		
		for(int n: numeros) {
			if(condicion.test(n)) {
				suma+=n;
			}
		}
		return suma;
	}
	// Así define que la condición la decidirá quien llame al método.
	// Así vemos que se pueden pasar interfaces como parámetros. Pudiendo hacer flexibles los métodos.
	
	
	
	// Más ejercicios:
	
	//método que recibe una lista de números e imprime los pares
	//método que recibe un conjunto de números y guarda en un fichero los positivos
	//método que recibe una lista y guarda en un fichero los múltiplos de cinco
	//método que recibe un conjunto de números e imprime los negativos 
	
	public void operacion(Collection<Integer> numeros, Predicate<Integer> condicion, Consumer<Integer> op) {
	
		for(Integer n: numeros) {
			if(condicion.test(n)) {
				op.accept(n);
			}
		}
	}
	
	
	// método que recibe una lista y devuelve la suma de todos los elementos de la lista, 
	// añadiendo el valor que se extraiga de un fichero.
	// método que recibe una lista y devuelve la suma de todos los elementos de la lista, 
	// a le añadimos un número léido desde un puerto externo.
	
	public int sumaExtra(List<Integer> numeros, Supplier<Integer> sup) {
		// Sirve asi el supplier para con su método get obtener los datos.
		int suma = 0;
		for(Integer n:numeros) {
			suma+=n;
		}
		suma+=sup.get();
		return suma;
	}
	
	/**
	 * 
	 	//simula la obtención de una conexión
		//con una base de datos
		Supplier<Connection> sp=()->{
			 String cad="cadena conexión BD";
			 String user="usuario";
			 String pwd="password";
			 Connection cn;
			 cn=DriverManager.getConnection(cad,user,pwd);
			 return cn;
		}
		
		//uso
		Connection cn=sp.get();

	 */
	
}





