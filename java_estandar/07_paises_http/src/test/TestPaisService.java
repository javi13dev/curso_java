package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import service.PaisService;

class TestPaisService {
	
	static PaisService service = new PaisService();
	
	@Test
	void testMostrarContinentes() {
		assertEquals(8, service.mostrarContinentes().size());
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
		assertEquals(8, service.paisesPorContinente().size());
	}
	
	
	@Test
	void testMostrarPais() {
		assertEquals("Afghanistan", service.mostrarPaisPorCapital("Kabul").get().getNombre());
	}
	
	
}
