package principal;
import java.util.Scanner;

public class Notas {

	public static void main(String[] args) {
		
		// realizar un programa que solicite una a una la introducción 
		// de 6 notas.
		// Que serán guardadas en un array
		// Tras ello, el programa mostrará los siguientes datos:
		// -Nota media
		// -Nota más alta
		// -Aprobados(cada nota que sea un aprobado)
		
		Scanner sc = new Scanner(System.in);
		
		double [] notas = new double[6];
		double nota; 
		
		double total = 0;
		double notaAlta = 0;
			
		for(int i = 0; i < notas.length; i++) {
			System.out.println("Ingrese una nota:");
			nota = sc.nextDouble();
			notas[i] = nota;
		}
		
		// Nota media
		for(int i = 0; i <notas.length; i++) {
			total = total+ notas[i];
		}
		System.out.println("nota media: " + total/notas.length);
		
		// La nota más alta
		
		for(double n:notas) {
			// Si la nota que leo es mayor a la notaAlta, se actualiza
			if(n>notaAlta) {
				notaAlta = n;
			}
		}
		System.out.println("Nota más alta: "+notaAlta);
		
		// Los aprobados
		for(double n:notas) {
			if(n>=5) {			
				System.out.println(n + " aprobado: ");
			}
		}
		
	}
}
