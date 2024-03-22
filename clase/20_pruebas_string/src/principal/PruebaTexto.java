package principal;

public class PruebaTexto {

	public static void main(String[] args) {
		String n="hello";
		n=n.toUpperCase();
		System.out.println(n);
		
		/*String a=new String("mitexto");
		String b=new String("Mitexto");
		if(a.equalsIgnoreCase(b)) {
			System.out.println("Iguales");
		}else {
			System.out.println("Distintos");
		}*/
		String a="mitexto";
		String b="mitexto";
		if(a==b) {
			System.out.println("Iguales");
		}else {
			System.out.println("Distintos");
		}

	}

}
