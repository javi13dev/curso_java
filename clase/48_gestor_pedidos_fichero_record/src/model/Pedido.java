package model;

import java.time.LocalDate;

public record Pedido(String producto, int unidades, LocalDate fechaPedido) {
	// un constructor sin parámetros
	public Pedido() {
		this(null,0,LocalDate.of(1,1,1));
	}
}
