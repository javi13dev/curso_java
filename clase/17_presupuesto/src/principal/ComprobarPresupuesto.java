package principal;
import java.util.Scanner;

public class ComprobarPresupuesto {

	public static void main(String[] args) {
		// Dado una serie de precios de coches
		// Se le pide al cliente cuál es su presupuesto
		// El programa indicará a cuántos coches puede optar
		
		Scanner sc = new Scanner(System.in);
		
		double [] precios = {19_500.0, 23_450, 17_300, 33_500, 25_340, 41_800};
		
		int cont = 0;
		System.out.println("Indica tu presupuesto:");
		double presupuesto = sc.nextDouble();
		
		
		for(double precio:precios) {
			if(presupuesto>=precio) {
				cont++;
			}
		}
		
		System.out.println("Optas a " + cont + " coches");

	}
}
