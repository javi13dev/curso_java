package principal;

public class SumarHastaMil {

	public static void main(String[] args) {
		// 
		int num = 1;
		int suma = 0;
		
		while(suma <= 1000) {
			System.out.println("el numero es "+num);
			suma = num + (num + 1);
		
			System.out.println(suma);
			num++;
		}
		System.out.println(num);
	}

}
