package principal;

import service.Punto3D;

public class Test {

	public static void main(String[] args) {
		Punto3D pd = new Punto3D(25);
		
		// ahora pd. tiene todos los métodos, tanto de object como de la clase padre Punto.
		pd.imprimir();

	}

}
