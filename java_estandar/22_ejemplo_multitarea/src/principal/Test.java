package principal;

import tareas.TareaAscendente;
import tareas.TareaDescendente;

public class Test {

	public static void main(String[] args) {
		
		// var ta = new TareaAscendente();
		// var td = new TareaDescendente();
		
		TareaAscendente ta = new TareaAscendente();
		TareaDescendente td = new TareaDescendente();
		
		ta.start();
		td.start();
	}

}
