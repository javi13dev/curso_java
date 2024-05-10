package tareas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import recursos.Recurso;

public class HiloConsumidor implements Runnable {
	
	// Se le pasa el Lock para realizar el equivalente al synchronized
	
	// Recibimos 4 objetos:
	private Recurso recurso;
	private Lock lock;
	private Condition condicionLleno;
	private Condition condicionVacio;
	
	public HiloConsumidor(Recurso recurso, Lock lock, Condition condicionLleno, Condition condicionVacio) {
		super();
		this.recurso = recurso;
		this.lock = lock;
		this.condicionLleno = condicionLleno;
		this.condicionVacio = condicionVacio;
	}

	@Override
	public void run() {
		while(true) {
			lock.lock();
			if(recurso.isVacio()) {
				try {
					System.out.println("Recurso vacío, esperando...");
					condicionVacio.await();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Consumiendo: "+recurso.sacar());
			condicionLleno.signal();
			lock.unlock(); // hasta que no se de el unlock no entra dentro otra condition
		
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
