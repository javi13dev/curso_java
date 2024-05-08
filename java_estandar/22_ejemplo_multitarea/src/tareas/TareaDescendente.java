package tareas;

public class TareaDescendente extends Thread {

	@Override
	public void run() {
		for(int i=100; i>0 ; i--) {
			System.out.println("Descendete " + i);
		}
	}
}
