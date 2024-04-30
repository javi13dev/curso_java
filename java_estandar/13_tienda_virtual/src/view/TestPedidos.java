package view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import service.PedidoService;

public class TestPedidos {
	
	static PedidoService service = new PedidoService();
	public static void main (String [] args) {
		
		/*
		LocalDate fecha_base = LocalDate.of(2000, 10, 10);
		LocalTime hora = LocalTime.now();
		LocalDateTime f1 =  LocalDateTime.of(fecha_base, hora);
		LocalDateTime f2 = LocalDateTime.now();
		
		
		service.pedidosEntreFechas(f1, f2);
		*/

		service.pedidosEntreFechas(LocalDateTime.of(2020, 1, 1, 1, 1), 
				LocalDateTime.of(2024, 1, 1, 1, 1))
		.forEach(System.out::println);
	}

}
