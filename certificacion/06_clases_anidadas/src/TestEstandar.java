class Externa{
	class Interna{
		void print() {
			System.out.println("Clase interna");
		}
	}
}
public class TestEstandar {

	public static void main(String[] args) {
		/*Externa ex=new Externa();
		Externa.Interna in=ex.new Interna();*/
		Externa.Interna in=new Externa().new Interna();
		in.print();

	}

}
