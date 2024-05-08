package tareas;

public class TestTablaMultiplicar {

	public static void main(String[] args) {
		
		TareaMultiplicar tm = new TareaMultiplicar(10);
		TareaMultiplicar tm2 = new TareaMultiplicar(3);
		TareaMultiplicar tm3 = new TareaMultiplicar(7);
	
		
		Thread tr1 = new Thread(tm);
		Thread tr2 = new Thread(tm2);
		Thread tr3 = new Thread(tm3);
		
		tr1.start();	
		tr2.start();
		tr3.start();
		
		new Thread(new TareaMultiplicar(5)).start();
	}
}





