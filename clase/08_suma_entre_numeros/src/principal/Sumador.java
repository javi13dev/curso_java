package principal;

public class Sumador {

	public static void main(String[] args) {
		int n1=20;
		int n2=11;
		// calcular la suma de todos los números comprendidos entre el mayor y el menor
		// no incluidos los extremos
		int suma = 0;
		int diferencia;
		
		if(n1>n2) {
			diferencia = n1-n2;
			for(int i = 1; i<diferencia; i++) {
				suma = suma + n2+1;
				System.out.println(suma);
				n2++;
			}
			
		}else {
			diferencia = n2-n1;
			for(int i = 1; i<diferencia; i++) {
				suma = suma + n1+1;
				System.out.println(suma);
				n1++;
			}
		}
	}
}
