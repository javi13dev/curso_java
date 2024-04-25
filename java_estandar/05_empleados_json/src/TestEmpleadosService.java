import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import principal.EmpleadosService;

class TestEmpleadosService {
	
	static EmpleadosService service = new EmpleadosService();
	
	@Test
	void testMostrarEmpledaos() {
		assertEquals(1, service.mostrarEmpledaos("ventas").size());
	}
	

	@Test
	void testEmpMayorSalario() {
		assertEquals("Javier", service.empMayorSalario().getEmpleado());
	}

	@Test
	void testDepartamentos() {
		assertEquals(3, service.departamentos().size());
	}

}
