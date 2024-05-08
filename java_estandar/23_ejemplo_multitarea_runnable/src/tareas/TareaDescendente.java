package tareas;

public class TareaDescendente implements Runnable {

	@Override
	public void run() {
		for(int i=100; i>0 ; i--) {
			System.out.println("Descendete " + i);
		}
	}
}
