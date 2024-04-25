package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import principal.PaisService;

class TestPaisService {
	
	static PaisService service = new PaisService();
	
	@Test
	void testMostrarContinentes() {
		assertEquals(7, service.mostrarContinentes().size());
	}
	
	@Test
	void testMostrarPaises() {
		assertEquals(53, service.mostrarPaises("Europe").size());
	}

	@Test
	void testPaisMasPoblado() {
		assertEquals("China", service.paisMasPoblado().getNombre());
	}

	@Test
	void testPaisesPorContinente() {
		assertEquals(7, service.paisesPorContinente().size());
	}
	
	/**
	@Test
	void testMostrarPais() {
		assertEquals("Afghanistan", service.mostrarPais("Kabul"));
	}
	*/
	
}
