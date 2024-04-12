package pruebas;

class M1 {
	int a;
	static int b = 1;
	M1(){
		a++;
		b++;
	}
}


class M2 extends M1{
	int a;
	static int b;
	M2(){
		/**
		 * Así podemos acceder a las variables heredadas.
		 * 
		 * super.a++;
		 * M1.b++;
		 */
		a++;
		b++;
	}
}

public class Test_01 {

	public static void main(String[] args) {
		M1 m1 = new M1();
		M2 m2 = new M2();
		
		System.out.println(m2.a + " " + m2.b); // 1:1
		System.out.println(m1.a + " " + m1.b); // 1:3
		System.out.println();

	}
}

