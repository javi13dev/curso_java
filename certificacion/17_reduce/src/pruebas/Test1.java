package pruebas;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		String cad="a,b,c,d,e";
	System.out.println(Arrays.stream(cad.split(","))
		.reduce((x,y)->y.equals("c")?x+"-":x+y)
		.get()); //ab-de

	}

}
