package principal_test;

import principal.ListNumber;

public class Test {

	public static void main(String[] args) {
		ListNumber lista = new ListNumber();
		
		lista.add(20);
		lista.add(30);
		lista.add(10);
		lista.add(20);
		
		System.out.println(lista.first());
		System.out.println(lista.last());
		System.out.println(lista.sum());
		
	}

}
