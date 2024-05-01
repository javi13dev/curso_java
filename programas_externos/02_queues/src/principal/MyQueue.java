package principal;

import java.util.Queue;
import java.util.LinkedList;

public class MyQueue {

	public static void main(String[] args) {
		// FIFO
		Queue<String> cajero = new LinkedList<>();
		
		cajero.offer("Vaneas");
		cajero.offer("Tontin");
		
		String primerCliente = cajero.poll(); // Para sacar el primer elemento añadido.
		System.out.println("Cliente atendido: " + primerCliente); // Vaneas
		// Para mostrar un cliente pero sin sacarlo de la la lista:
		String cliente = cajero.peek();
		System.out.println("Primer cliente: " + cliente); // Tontin
		
	}

}
