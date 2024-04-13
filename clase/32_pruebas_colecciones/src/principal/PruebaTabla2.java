package principal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry; // Para recorrer el hashmap

public class PruebaTabla2 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> ciudades=new HashMap<String, Integer>();
		
		// put para ingresar
		
		ciudades.put("Madrid", 3200000);
		ciudades.put("Zaragoza", 300000);
		ciudades.put("Caceres", 100000);
		ciudades.put("Caceres", 120000);

		//recorrido de un HashMap con Entry
		
		for(Entry<String, Integer> entry : ciudades.entrySet()) {
			System.out.println( "Clave: " + entry.getKey() + "valor: " + entry.getValue());
		}
		
		//claves:
		Set<String> claves=ciudades.keySet();
		for(String n:claves) {
			System.out.println(n);
		}
		//valores:
		Collection<Integer> valores=ciudades.values();
		for(Integer n:valores) {
			System.out.println(n);
		}


	}

}
