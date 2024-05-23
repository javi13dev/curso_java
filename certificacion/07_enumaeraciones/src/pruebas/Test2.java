package pruebas;
public class Test2 {
	enum Posicion{
		NORTE(2), SUR(1), ESTE(5), OESTE(3);
		int s;
		Posicion(int s){
			this.s=s;
		}
	}
	public static void main(String[] args) {
		Posicion[] pos= {Posicion.NORTE,Posicion.ESTE,Posicion.OESTE};
		pos[1].s=3; //1
		for(Posicion p:pos) {
			System.out.print(p.name()+" ");
		}
		
		
		System.out.print(pos[0].s+" ");
		System.out.print(pos[0].name()+" ");
		System.out.print(pos[1].s+" ");
		
		System.out.print(pos[2].s+" ");
	}
}