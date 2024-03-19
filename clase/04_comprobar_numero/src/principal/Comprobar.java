package principal;

public class Comprobar {

	public static void main(String[] args) {
		// Operador ternario
		int a = 1;
		int b = 5;
		int c = 10;
		
		// si el número es par, nos muestra la mitad del número, si es impar muestra la mitad del anterior.
		
		if(c%2==0) {
			System.out.println(c/2);
		}else{
			System.out.println(--c/2);
		}

	}

}
