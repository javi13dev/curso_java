package principal;

public class Suma_Pares {

	public static void main(String[] args) {
		
		int suma = 0;
		
		for(int i = 1; i<=10; i++) {
			// calcula la suma de todos los números pares comprendidos entre 1 y 10
			if(i%2==0) {
				suma = suma + i;
				System.out.println(suma);
			}
		}

	}

}
