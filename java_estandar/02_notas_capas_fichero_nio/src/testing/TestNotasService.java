package testing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.NotasService;

class TestNotasService {
	// Al seleccionar el beforeAll vamos a dar de alta unas notas previamente a los tests
	static NotasService service = new NotasService();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service.borrarNotas();
		service.agregarNota(5);
		service.agregarNota(8);
		service.agregarNota(1);
		service.agregarNota(6);
	}

	@Test
	void testMedia() {
		// método para hacer suposiciones.
		assertEquals(5.0, service.media());
	}

	@Test
	void testMax() {
		assertEquals(8.0, service.max());
	}

	@Test
	void testMin() {
		assertEquals(1.0, service.min());
	}
	
	@Test
	void testObtenerNotas() {
		// Para comparar array o colleciones, comprobamos el número de elementos.
		assertEquals(4, service.obtenerNotas().size());
		// o bien un método directo para comparación de arrays:
		//assertArrayEquals(new Double[] {5.0,8.0,1.0,6.0}, service.obtenerNotas().toArray(new Double[0]));
	}
}
