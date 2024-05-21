import java.awt.Component;
import java.awt.Container;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		Integer n = 10;
		// instanceof()   -> a es un b?
		// Se usa con tipos objetos.
		
		System.out.println(n instanceof Integer);
		System.out.println(n instanceof Number);
		// System.out.println(n instanceof String); // No hay relación de herencia, error de compilación.
		System.out.println(n instanceof Object);
		
		Container cmp = new Container(); // Se pregunta/compara por el objeto de la variable
		// No hay problema de compilación porque hay relación de herencia, pero habrá falses.
		System.out.println(cmp instanceof JFrame);
		System.out.println(cmp instanceof Component);
		System.out.println(cmp instanceof JButton);
		
		
		
		
		Object obj = "200";
		
		System.out.println(obj instanceof Integer); // false
		System.out.println(obj instanceof String); // True
		System.out.println(obj instanceof CharSequence); // true porque esta interfaz la implementa String
		System.out.println(obj instanceof List); // False
		
		/*
		 * Desde Java 16 se puede utilizar instanceof para asignar el 
			objeto a una variable del tipo específico, sin realizar un cast:
			
			Coincidencia de patrones. (Pattern match)
		 */
		
		/*
		 * Antes de java 16:
		 * 
		 * 	Object obj=new String("Mi cadena");
			if(obj instanceof String) {
				 String s=(String)obj;
				 System.out.println("Longitud: "+s.length());
			}

		 */
		
		/*
		 *  A partir de java 16
		 * 
		 *  Object obj=new String("Mi cadena");
			if(obj instanceof String s) {
			 	System.out.println("Longitud: "+s.length());
			}

		 */
		

	}

}
