package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pruebas {

	public static void main(String[] args) {
		// Probando LocalDate
		// LocalDate es inmutable, los cambios generan nuevos objetos
		
		LocalDate fechaActual = LocalDate.now();
		LocalDate fecha = LocalDate.of(2002, 04,23);
		
		System.out.println(fechaActual);
		// 2024-04-05
		System.out.println(fecha);
		// 2002-04-23
		
		// También tenemos:
		// LocalTime
		// LocalDatetime
		
		// Formato a partir de un String
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaString="20/09/2019";
		LocalDate dateFromString=LocalDate.parse(fechaString, format);
		System.out.println(dateFromString);
		
		// Formato a partir de una fecha
		LocalDate date=LocalDate.of(2022,10,20);
		System.out.println(date.format(format)); //20/10/2022
		
		// Y tenemos métodos de comparación:
		// isBefore(f)
		// isAfte(f)
		// compareTo(f)
		
		
		// Tenemos también métodos para agregale tiempos:
		// LocalDate minus/plusYears(long cantidad)
		// LocalDate minus/plusMonths(long cantidad)
		// LocalDate minus/plusDays(long cantidad)
		
		LocalDate f4 = LocalDate.of(2002, 04,23);
		System.out.println(f4.plusMonths(5));
		System.out.println(f4.minusDays(10));

	}

}
