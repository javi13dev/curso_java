package principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clasicas {

	public static void main(String[] args) throws ParseException {
		// Momento (fecha y hora) actual:
		Date date = new Date();
		Date max = new Date(Long.MAX_VALUE);
		System.out.println(date);
		System.out.println(max);
		
		// Momento determinado:
		Calendar cal = Calendar.getInstance();
		cal.set(2000, 03, 23);
		// Puede pasarse fecha y hora
		// cal.set(2000, 03, 23, 10, 14, 30);
		Date f2 = cal.getTime();
		System.out.println(f2);
		
		// Fecha desde una cadena de caracteres:
		String fecha = "4/10/1999";
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date f3 = format.parse(fecha);
		
		System.out.println(f3);
		
		
	}

}
