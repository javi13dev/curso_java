package principal;

import service.Circulo;
import service.Figura;
import service.Triangulo;

public class Test {

	public static void main(String[] args) {
		// Así podemos ver como se accede desde la clase padre
		
		Figura f=new Circulo("Verde",5);
		System.out.println("Color: " + f.getColor() + " Área. " + f.area());
		
		f=new Triangulo("Rojo",6,2);
		System.out.println("Color: " + f.getColor() + " Área: " + f.area());
	}
}
