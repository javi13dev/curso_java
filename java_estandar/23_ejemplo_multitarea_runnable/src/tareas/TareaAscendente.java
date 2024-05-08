package tareas;

public class TareaAscendente implements Runnable {

	@Override
	public void run() {
		for(int i=1; i<101 ; i++) {
			System.out.println("Ascendente " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
