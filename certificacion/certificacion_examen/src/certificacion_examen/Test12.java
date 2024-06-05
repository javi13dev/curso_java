package certificacion_examen;

class Pet{
	static String name;
	
	Pet(String name){
		name = name;
	}
}

class Dog extends Pet{
	Dog(String name){
		super(name);
	}
}

public class Test12 {

	public static void main(String[] args) {

		Pet p = new Dog("Dog");
		Pet p1 = p;
		p1.name = "Cat";
		
		p = p1;
		System.out.println(p.name);
		
		p = null;
		System.out.println(p1.name);
	}
	
	
	/*
	 * 
	 * 
	 A. Cat
	 	Dog
	 	
	 B. A NullPointerException is thrown
	 	Cat			// Imprime Cat Cat
	 	Cat
	 	
	 C. Dog 
	 	Dog
	 	
	 D. Cat
	 	Null
	 */
	 */

}
