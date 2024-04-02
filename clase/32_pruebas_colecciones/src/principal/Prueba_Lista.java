package principal;

import java.util.ArrayList;

public class Prueba_Lista {
	public static void main(String[] args) {
		ArrayList<String> cadenas=new ArrayList<>();
		ArrayList<Integer> numeros=new ArrayList<>();
		var decimales=new ArrayList<Double>();
		System.out.println(cadenas.size());
		cadenas.add("lunes");
		cadenas.add("martes");
		cadenas.add(0,"miércoles");
		//cadenas.add(7,"jueves");  //Excepción
		//System.out.println(cadenas.get(2));
		
		/*numeros.add(35);
		numeros.add(numeros.get(0));
		numeros.set(0, 100);
		System.out.println(numeros.get(1));
		numeros.set(1, 40);*/
		cadenas.remove(1);//elimina "lunes"
		
		if(!cadenas.contains("martes")) {
			cadenas.add("martes");
		}
		for(int i=0;i<cadenas.size();i++) {
			System.out.println(cadenas.get(i));
		}
	
		
	}
}
