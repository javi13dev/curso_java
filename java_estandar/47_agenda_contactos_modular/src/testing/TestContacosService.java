package testing;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.ContactosService;
import service.ContactosServiceFactory;

class TestContacosService {
	static ContactosService service; // Aqui gracias a la interfaz:
	
	@BeforeAll
	static void setupBeforeClass() throws Exception{
		service = ContactosServiceFactory.getContactosService(); // Se obtiene mediante la instanciación de un objeto 
																// ContactosServiceFactory
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
