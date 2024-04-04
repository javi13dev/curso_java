package principal;

import java.util.HashSet;

/**
 * inmutables: String, envoltorios y nuevos tipos de fechas
 */

class MyNumber{
	private Double num;

	public MyNumber(Double num) {
		super();
		this.num = num;
	}

	public Double getNum() {
		return num;
	}

	public void setNum(Double num) {
		this.num = num;
	}
}

public class Prueba_Conjunto2 {

	public static void main(String[] args) {
		HashSet<MyNumber> numeros = new HashSet<MyNumber>();
		
		numeros.add(new MyNumber(10.5));
		numeros.add(new MyNumber(40.1));
		numeros.add(new MyNumber(60.2));
		
		for(MyNumber n: numeros) {
			n.setNum(n.getNum()+1);
			System.out.println(n.getNum());
		}
		
		for(MyNumber n: numeros) {
			System.out.println(n.getNum());
		}
	}
}
