package principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class GuardarCursosFicheros {

	public static void main(String[] args) {
		String [] cursos= {
			"Java básico",
			"Python para principaiantes",
			"Java EE en Web",
			"JavaScript en Front",
			"POO con Java",
			"Python y Django",
			"Desarrollo Web con ASP.NET",
			"Aplicaciones Web con Python"
		};
		
		//solicitamos por teclado la introducción de un 
		//nombre y guardaremos en un fichero todos los
		//cursos que contengan ese nombre
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce nombre");
		String nombre=sc.nextLine();
		guardarCursos(nombre,cursos);
	}
	static void guardarCursos(String nombre,String[] cursos) {
		String ruta="cursos.txt";
		try(PrintStream out=new PrintStream(ruta)) {
			for(String c:cursos) {
				//si el curso contiene ese nombre se guarda
				if(c.contains(nombre)) {
					out.println(c);
				}
			}
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
