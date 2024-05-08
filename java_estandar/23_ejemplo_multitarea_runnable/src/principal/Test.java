package principal;

import tareas.TareaAscendente;
import tareas.TareaDescendente;

public class Test {

	public static void main(String[] args) {
		
		// var ta = new TareaAscendente();
		// var td = new TareaDescendente();
		
		TareaAscendente ta = new TareaAscendente();
		TareaDescendente td = new TareaDescendente();
		
		// hay que crear objetos de la propia clase Thread, y hay que pasarle
		// como parámetro el objeto runnable
		
		Thread tar = new Thread(ta);
		Thread tdr = new Thread(td);
		
		tar.start();
		tdr.start();
	}

}
