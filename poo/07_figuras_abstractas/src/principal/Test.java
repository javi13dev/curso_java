package principal;

import service.Circulo;
import service.Figura;
import service.Mesa;
import service.Triangulo;

public class Test {

	// Añadir una nueva clase llamada mesa, con tres atributos, ancho, alto y largo que implemente la interfaz Operaciones
	public static void main(String[] args) {
		// Así podemos ver como se accede desde la clase padre
		
		Figura f=new Circulo("Verde",5);
		mostrar(f);
		
		f=new Triangulo("Rojo",6,2);
		mostrar(f);
		System.out.println();
		
		// El objeto puede acceder al método de la interfaz
		Triangulo t = new Triangulo("Azul", 5, 4);
		t.girar(10);
		
		Mesa mesa = new Mesa(10,20,10);
		mesa.girar(5);
		System.out.println("Altura " + mesa.getAlto());
		System.out.println("Ancho " + mesa.getAncho());
		System.out.println("largo " + mesa.getLargo());
		System.out.println("Eje x: " + mesa.invertir());
	}
	
	public static void mostrar(Figura f) {
		System.out.println("Color: " + f.getColor() + " Área. " + f.area());
	}
}
