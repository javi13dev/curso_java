package certificacion_examen;

public class Test6 {

	static interface Animal {
		
	}
	
	static class Dog implements Animal{
		
	}
	
	private static void play(Animal a) {
		System.out.println("flips");
	}
	
	private static void play(Dog d) {
		System.out.println("runs");
	}
	
	public static void main(String [] args) {
		Animal a1 = new Dog();
		Dog a2 = new Dog();
		play(a1);
		play(a2);
	}
	
	/*
	 * What is the result?
	 * 
	 * a) flipsflips
	 * b) COmpilation fails
	 * c) flipsruns  // Esta es la correcta.
	 * d) runsflips
	 */
}
