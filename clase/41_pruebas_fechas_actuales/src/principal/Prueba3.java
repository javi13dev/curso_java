package principal;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Prueba3 {

	public static void main(String[] args) {
		LocalDate f1= LocalDate.of(2023, 11, 4);
		LocalDate f2= LocalDate.of(2034, 3, 7);
		
		Period p = Period.between(f1, f2);
		long dias1 = p.get(ChronoUnit.DAYS);
		System.out.println("Total dias primer periodo: " + dias1);
		System.out.println(ChronoUnit.DAYS.between(f1, f2)); 
		
		System.out.println(p.getMonths() + " meses");
		System.out.println(p);
		
		// **********
		LocalDate f3= LocalDate.of(2022, 4, 4);
		LocalDate f4= LocalDate.of(2022, 5, 7);
		
		Period p2 = Period.between(f3, f4);
		long dias2 = p.get(ChronoUnit.DAYS);
		System.out.println(ChronoUnit.DAYS.between(f3, f4)); 
		
		System.out.println("Total dias segundo periodo: " + dias2);
		
		System.out.println(p.getMonths() + " meses");
		System.out.println(p);
	}
}
