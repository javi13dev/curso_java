package principal;

public class Comprobar {

	public static void main(String[] args) {
		// Operador ternario
		int a = 1;
		int b = 5;
		int c = 16;
		
		// si el número es par, nos muestra la mitad del número, si es impar muestra la mitad del anterior.
		
		if(c%2==0) {
			System.out.println(c/2);
		}else{
			System.out.println(--c/2);
		}
		
		System.out.println(c%2==0? (c/2) : (--c/2));
		// La variable si no hace falta modificarla o no lo indica, mejor no modificar su valor.
		
		/**
		 
		int a=10;
		int b=a++;
		int c=++b;
		System.out.println(a<b?b>c?a--:c++:--b); //10

		if(a<b){
			if(b>c){
				a--;
			}else{
				c++;
			}
		}else{
			--b;
		} 
		
		*/
	}

}
