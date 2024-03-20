package principal;

public class SumarHastaMil {

	public static void main(String[] args) {
		// 
		int num = 0;
		int suma = 0;
		
		
		do {
			num++;
			suma+=num;
		}while(suma<1000);
		System.out.println(num);

	}

}
