package principal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Lanzar dos tareas que se ejecuten concurrentemente.
		// Una de ellas calculará la suma de todos los números del 1 al 100
		// La otra calculará el factorial de un número cualquiera.
		
		// Cuando las tareas finalicen, el programa principal mostrará los resultados.
		// Mientras las tareas estén en ejecución, el programa principal puede hacer otras funciones.
		
		
		// 1) Ya no necesitamos el executor, llamamos al método supplyAsync porque tenemos un valor de retorno
		CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
			int suma = 0;
			for(int i=0; i<=100; i++) {
				suma+=i;
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return suma;
		});

		// 2) Tarea factorial de 6:
		
		CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
			int p = 1;
			for(int i=1; i<=6; i++) {
				p*=i;
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return p;
		});
		
		// 3) Ya no necesitamos el while
		
		f1.whenCompleteAsync((r, e) -> System.out.println("la suma es: " + r));
		f2.whenCompleteAsync((r, e) -> System.out.println("Factorial de 6 es: " + r));
		
		for(int i=0; i<=100 ; i++) {
			System.out.println("Ejecución asíncrona realizandose");
			Thread.sleep(50);
		}
		
		
		// Si termina el main y queda alguna ejecución pendiente se termina el programa.
		
		
		
		
	}
}
