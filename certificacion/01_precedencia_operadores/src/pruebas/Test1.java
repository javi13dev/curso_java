package pruebas;

public class Test1 {
	static int i;	

	public static void main(String[] args) {
		int a=2, b=7, c=1;
		System.out.println(c+=b+a);
		
		// Primero se ejecuta el b+a
		
		// Aqui c ya vale 10
		System.out.println(c*=b+a);
		
		
		
		int d = 2, e = i+1;
		if ((d++>++e) && (++d>5)) {
			d +=e;
		}
		
		System.out.println(d);
		
	}
	


}
