import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Pedido;
import service.PedidoService;

class TestPedido {
	
	static PedidoService service=new PedidoService();
	static Calendar calendar=Calendar.getInstance();
	
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
	void testPedidoProximoFecha() {
		assertEquals("coca cola", service.pedidoProximoFecha(LocalDate.of(2023, 12, 7)).producto());
		assertEquals("patatas fritas", service.pedidoProximoFecha(LocalDate.of(2022, 8, 7)).producto());
	}

	@Test
	void testPedidoMasReciente() {
		assertEquals("coca cola", service.pedidoMasReciente().producto());
	}

	@Test
	void testPedidosEntreFechas() {
		LocalDate fmin=LocalDate.of(2022, 1,1);
		LocalDate fmax=LocalDate.of(2022, 12,31);
		assertEquals(2, service.pedidosEntreFechas(fmin, fmax).size());
	}
}
