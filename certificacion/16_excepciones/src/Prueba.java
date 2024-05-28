

public class Prueba {

	public static void main(String[] args) {
		// 
		TestPropagacion op = new TestPropagacion();
		
		try {
			op.getData();  // Obliga a capturar la exception lanzada.
		} catch (DatoNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
