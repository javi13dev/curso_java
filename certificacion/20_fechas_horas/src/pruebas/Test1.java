package pruebas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Test1 {

	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.now();
		LocalDateTime ldt1 = LocalDateTime.now();
		ZonedDateTime zdt1 = ZonedDateTime.now(); // Se puede pasar la zona horaria, sino llama a donde se ejecuta.
		
		Instant i = Instant.now(); // UTC 0
		
		System.out.println(ld1);
		System.out.println(ldt1);
		System.out.println(zdt1);
		System.out.println(i);
		
	}

}
