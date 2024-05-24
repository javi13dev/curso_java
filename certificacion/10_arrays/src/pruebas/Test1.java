package pruebas;

public class Test1 {
	
	public static void main(String [] args) {
		
		var n = {1,2,3}; // En inferencia de tipos no se permite la forma abreviada.
		var m = new int []{1,2,3};
		
		int[] a = {5,6,7};
		int[] b = new int [] {5,6,7};
		
		
		// Otro ejemplo:
		
		byte ar=(int)9;
		byte f=9;
		f=f+1;
		f++;//f=(byte)f+1;
	}

}
