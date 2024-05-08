package tareas;

public class TareaMultiplicar implements Runnable {
	
	private int num;
	
	public TareaMultiplicar(int n) {
		this.num = n;
	}
	@Override
	public void run() {
		for(int i=0; i<11 ; i++) {
			System.out.println(num + "x" + i + " = " +  num*i);
		}
	}

}
