package principal;

public class Arrays {

	public static void main(String[] args) {
		// Probando arrays
		
		
		int prueba[];
		prueba = new int [5];
		
		// Programa que sume un punto a cada alumno
		// mostrar todas las notas
		
		int [] notas = {3,8,5,4,9};
		
		for(int i=0; i<notas.length; i++) {
			notas[i] = notas[i] + 1;
			System.out.println(notas[i]);
		}
		
		// for each
		for (int nota:notas) {
			System.out.println(nota);
		}
	}

}
