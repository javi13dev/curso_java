package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.CuentasService;

class TestCuentasService {
	static CuentasService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service = new CuentasService();
	}

	@Test
	void testExisteCuenta() {
		assertTrue(service.existeCuenta("ES1420800222823000247854"));
		assertFalse(service.existeCuenta("ES1421"));
	}

	@Test
	void testNumeroDivisas() {
		assertEquals(2, service.numeroDivisas("EUR"));
	}
	
	// Probando test de los últimos métodos
	// Ejemplo de método que me devuelve un optional y lo comprobamos con sus métodos.
	@Test
	void testBuscarCuentaPorTitular() {
		assertTrue(service.buscarCuentaPorTitular("Fernando López Gómez").isPresent());
	}

}
