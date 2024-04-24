import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Pedido;
import service.PedidoService;

class TestPedido {
	
	static PedidoService service = new PedidoService();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Declaro unas fechas posibles
		service.borrarPedidos();
		
		/**
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			
			String fechaInicial = "10-04-2020";
			String fechaFinal = "10-04-2023";
			
			Date fInicial = format.parse(fechaInicial);
			Date fFinal = format.parse(fechaFinal);
		 * 
		 */

		LocalDate f1 = LocalDate.of(2023, 11, 30);
		LocalDate f2 = LocalDate.of(2022, 4, 11);
		LocalDate f3 = LocalDate.of(2022, 10, 1);
		
		service.addPedido(new Pedido("coca cola", 20, f1));
		service.addPedido(new Pedido("whisky", 1, f2));
		service.addPedido(new Pedido("patatas fritas", 10, f3));
		
		
	}

	@Test
	void testBuscarPedidoMasReciente() {
		assertEquals("coca cola", service.buscarPedidoMasReciente().getProducto());
	}
	
	@Test
	void testPedidosEntreFechas() {

		LocalDate fMin = LocalDate.of(2022, 1, 1);
		LocalDate fMax = LocalDate.of(2023, 11, 1);
		
		// Porque el resultado son dos pedidos, y el test  va en esa suposición
		//assertEquals(2, service.buscarPedidos(fMin, fMax).size());
		assertEquals(2, service.pedidosEntreFechas(fMin, fMax).size());
	}
}
