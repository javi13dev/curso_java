package view;

import service.GatoService;
import service.GatoServiceFactory;

public class Test {

	public static void main(String[] args) {
		
		GatoService service = GatoServiceFactory.getGatoService();
		
		service.listGatos().stream()
		.forEach(g -> System.out.println(g.getNombre() + " " + g.getPeso()));

	}

}
