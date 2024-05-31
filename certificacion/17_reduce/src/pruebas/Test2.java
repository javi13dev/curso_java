package pruebas;

import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) {
		String cad="a,b,c,d,e";
		System.out.println(Arrays.stream(cad.split(","))
			.reduce("Concat: ",(x,y)->y.equals("c")?x+"-":x+y));

	}
}
