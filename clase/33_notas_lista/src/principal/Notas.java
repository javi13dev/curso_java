package principal;

import java.util.ArrayList;
import java.util.Scanner;

	/**
	 * Realizar un programa para solicitar al usuario las notas de un grupo de alumnos.
		Al iniciarse el programa, se le pide al usuario que introduzca una nota y esta se guardará. 
		Después, se le pregunta si quiere introducir una nueva nota, si dice que sí,
		se le pide otra nota y así sucesivamente hasta que diga que no.
		Cuando se hayan guardado todas las notas, el programa mostrará los siguientes datos:
		-Nota media
		-Aprobados
		-Nota más alta 
	 */

public class Notas {
	public static void main(String[] args) {
		ArrayList<Integer> notas=new ArrayList<Integer>();
		int nota;
		String respuesta;
		Scanner sc=new Scanner(System.in);
		
		
		do {
			//pedir nota, guardarla y preguntar si quiere
			//introducir otra
			System.out.println("Introduce nota");
			nota=Integer.parseInt(sc.nextLine());
			notas.add(nota);
			System.out.println("Quieres introducir otra nota?(s/n)");
			respuesta=sc.nextLine();
			
		}while(respuesta.equalsIgnoreCase("s"));
		// idea, después del while, pueda llamar a métodos:
		// calcularMedia(ArrayList(notas))
		// aprobados: calcularAprobados(ArrayList)
		// notaMasAlta: calcularNotaAlta(ArrayList)
		
		System.out.println("Nota media: " + calcularMedia(notas));
		System.out.println("Aprobados: " + aprobados(notas));
		System.out.println("La nota mayor es: " + notaMayor(notas));
	}
	
	static int calcularMedia(ArrayList<Integer> notas) {
		int suma = 0;
		int media = 0;
		for(int i=0;i<notas.size();i++) {
			suma = suma + notas.get(i);
			System.out.println(notas.get(i));
		}
		media = suma/notas.size();
		return media;
	}
	
	static int aprobados(ArrayList<Integer> notas) {
		int aprobados = 0;
		for (int i:notas) {
			if(i >= 5) {
				aprobados++;
			}
		}
		return aprobados;
	}
	
	static int notaMayor(ArrayList<Integer> notas) {
		int mayor = notas.get(0);
		for(int n:notas) {
			if(n>mayor) {
				mayor=n;
			}
		}
		return mayor;
	}
}

