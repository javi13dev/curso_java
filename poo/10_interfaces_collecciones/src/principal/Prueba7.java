package principal;

public class Prueba7 {
	
	public static void main(String[] args) {
		Double d=2.3;
		Integer integ=7;
		Float ft=3.4f;

		System.out.println(metodo(d));
		System.out.println(metodo(integ));
		System.out.println(metodo(ft));

	}
	public static int metodo(Number num){
		return num.intValue();
	}


}
