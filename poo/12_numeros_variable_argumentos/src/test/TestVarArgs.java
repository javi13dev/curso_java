package test;

public class TestVarArgs {

	public static void main(String[] args) {
		
		System.out.println(cadena("uno","dos","hodd"));
		System.out.println(cadena(new String[] {"uno","dos","hodd"}));
	}
	
	// crear un método que devuelva una cadena con la unión de todos los textos recibidos como parámetro.
	// separándolos por la coma.
	
	public static String cadena(String... data) {
		// El parámetro que se recibe es un array
		
		StringBuilder builder = new StringBuilder();
		
		for(String s:data) {
			builder.append(s);
			builder.append(",");
		}
		
		return builder.toString();
	}

}
