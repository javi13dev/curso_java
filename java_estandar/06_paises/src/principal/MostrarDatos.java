package principal;

import service.PaisService;

public class MostrarDatos {

	public static void main(String[] args) {

		var paisesService=new PaisService();
		paisesService.mostrarContinentes().forEach(System.out::println);

	}

}
