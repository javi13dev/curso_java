import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Pedido;
import service.PedidoService;

class TestPedido {
	
	static PedidoService service = new PedidoService();
	static Calendar calendar = Calendar.getInstance();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Declaro unas fechas posibles
		
		/**
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			
			String fechaInicial = "10-04-2020";
			String fechaFinal = "10-04-2023";
			
			Date fInicial = format.parse(fechaInicial);
			Date fFinal = format.parse(fechaFinal);
		 * 
		 */
		
		calendar.set(2023, 11, 30);
		Date f1 = calendar.getTime();
		calendar.set(2022, 4, 11);
		Date f2 = calendar.getTime();
		calendar.set(2022, 10, 1);
		Date f3 = calendar.getTime();
		
		
		service.addPedido(new Pedido("coca cola", 20, f1));
		service.addPedido(new Pedido("whisky", 1, f2));
		service.addPedido(new Pedido("patatas fritas", 10, f3));
		
		
	}

	@Test
	void testPedidoMasReciente() {
		assertEquals("coca cola", service.buscarPedidoMasReciente().getNombre());
	}
	
	@Test
	void testPedidosEntreFechas() {
		calendar.set(2022, 1, 1);
		Date fMin = calendar.getTime();
		calendar.set(2023, 11, 1);
		Date fMax = calendar.getTime();
		
		// Porque el resultado son dos pedidos, y el test  va en esa suposición
		//assertEquals(2, service.buscarPedidos(fMin, fMax).size());
		assertEquals(2, service.pedidosEntreFechas(fMin, fMax).size());
	}
	

}
