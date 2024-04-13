package principal;

import java.util.Stack;

public class PruebaStack {

	public static void main(String[] args) {
		// Estructuras de datos LIFO
		// Es decir, el último elemento en llegar será el primero en manejarse.
		
		Stack<Integer> myStack = new Stack<>();
		
		// Para introducir elmentos en el stack
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		myStack.push(40);
		
		// Para visualizarlo:
		System.out.println("Stack: "+ myStack);
		
		// Para ver el primer elemento:
		System.out.println(myStack.peek());
		
		// Para eliminar el primer elemento del stack:
		System.out.println(myStack.pop());
		
		System.out.println("Stack después de eliminar un elemento: " + myStack);
		
		// Para vaciar el stack, usamos clear()
		myStack.clear();
		System.out.println("Stack limpio: " + myStack);

	}

}
