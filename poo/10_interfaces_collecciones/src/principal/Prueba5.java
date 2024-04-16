package principal;
interface I1{
	void print();
}
class CA implements I1{ 
	public void print(){
		System.out.println("CA");
	}
}
class CB extends CA{
	public void print(){
		System.out.println("CB");
	}
}

class CC extends CB{
}

public class Prueba5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CC c = new CC();
		c.print();
		CB b=c;
		b.print();
		CA a = c;
		a.print();
		I1 i = c;
		i.print();

	}

}
