package principal;

import java.util.ArrayList;
import java.util.List;

public interface MiInterfaz extends List<Integer>{
	/**
	Crear una subinterfaz de List<Integer>, que añada los siguientes métodos estáticos:

	-List<Integer> ofPares(int n). 
	Devuelve una lista con los n primeros numeros pares
	
	-List<Integer> ofPositivos(int ... data). 
	Devuelve una lista solo con los números positivos del grupo de números recibidos como parámetro 
	 */

	static List<Integer> ofPares (int n){
		/**
		 * Válido cuando recibo una cadena y filtramos los valores pares
			List<Integer> lst = new ArrayList<>();
			
			for(int i:n) {
				if(i%2==0) {
					lst.add(i);				
				}
			}
			return lst;
			
		 */
		Integer[] result = new Integer[n];
		int num=0,cont=0;
		while(cont<n) {
			result[cont]=num;
			num+=2;
			cont++;
		}
		return List.of(result);
	}
	
	static List<Integer> ofPositivos (int... data){
		List<Integer> lst = new ArrayList<>();
		
		for(int i:data) {
			if(i>0) {
				lst.add(i);				
			}
		}
		return lst;
	}
}


