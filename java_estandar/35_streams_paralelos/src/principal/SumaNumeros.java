package principal;

import java.util.stream.LongStream;

public class SumaNumeros {
	// stream paralelos: divide las tareas de los streams en diferentes hilos.  parallel()
	public static void main(String[] args) {
		// Suma de todos los números entre 1 y 1000000.
		
		// System.out.println(LongStream.rangeClosed(1, 790010000L).sum());
		
		
		System.out.println(LongStream.rangeClosed(1, 790010000L)
				.parallel() // Con esta simple llamada, se realiza el modo multitarea. El resultado es el mismo.
				.sum());
		

	}

}
