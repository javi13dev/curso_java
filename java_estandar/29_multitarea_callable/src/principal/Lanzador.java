package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Lanzar dos tareas que se ejecuten concurrentemente.
		// Una de ellas calculará la suma de todos los números del 1 al 100
		// La otra calculará el factorial de un número cualquiera.
		
		// Cuando las tareas finalicen, el programa principal mostrará los resultados.
		// Mientras las tareas estén en ejecución, el programa principal puede hacer otras funciones.
		
		
		// 1) Creamos l ExecutorService:
		ExecutorService executor= Executors.newCachedThreadPool(); // Forma habitual de crearlo
		
		// 2) Definimos la tarea de la suma: mediante una expresión lambda.
		
		// mediante sprogramación funcional, aunque no permite añadir algo al proceso.
		//executor.submit(() -> IntStream.rangeClosed(1, 100).sum());
		
		
		// Con el sumbit() se lanza la tarea, la ejecución es asíncrona.
		// Para guardarlo se recoge en el objeto Future.
		Future<Integer> f1 = executor.submit(() -> {
			int suma = 0;
			for(int i=0; i<=100; i++) {
				suma+=i;
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return suma;
		});
		
		
		// 3) Tarea factorial de 6:
		
		Future<Integer> f2 = executor.submit(() -> {
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
		
		// 4) El main sigue haciendo algonhasta que las tareas terminen,
		// momento en el que se mostrarán los resultados.
		
		while(!f1.isDone() || !f2.isDone()) {
			System.out.println("f1 o f2 aún no han terminado");
		}
		
		System.out.println("Suma de los números: " + f1.get());
		System.out.println("Factorial de 6: " + f2.get());
		executor.shutdown();
		
	}

}
