package testing;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.ContactosService;

class TestContacosService {
	static ContactosService service;
	
	@BeforeAll
	static void setupBeforeClass() throws Exception{
		service = new ContactosService();
	}
	
	
	@Test
	void testBuscarContactoPorId() {
		assertEquals(50, service.buscarContactoPorId(7).getEdad());
		assertNull(service.buscarContactoPorId(40));
	}

	@Test
	void testGetContactos() {
		assertEquals(3, service.getContactos().size());
	}

}
