package cliente;

import java.util.Scanner;

import operaciones.Calculadora;

public class AppCalculadora {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1,n2;
		System.out.println("Introduce un número:");
		n1 = sc.nextInt();
		System.out.println("Introduce otro número:");
		n2 = sc.nextInt();
		
		// Cómo añadir librerias/proyectos externos que no stán en un .jar
		// >properties>Build Path>Projects>Module Path>Nuestro modulo.
		Calculadora cal = new Calculadora();
		
		System.out.println("La suma es: " + cal.sumar(n1, n2));
		System.out.println("La resta es: " + cal.restar(n1, n2));
		System.out.println("La multiplicación es: " + cal.multiplicar(n1, n2));
		System.out.println("La división es: " + cal.dividir(n1, n2));
	}

}
