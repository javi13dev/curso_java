package pruebas;

import java.util.Arrays;
import java.util.Comparator;

public class Test11Ordenacion {

	public static void main(String[] args) {
		
		String [] textos = {"hello", "by", "car", "send", "enter", "clear",
							"in", "step"};
		
		// Muestra las palabras ordenadas de menos a más caracteres
		// ,si tienen el mismo número de caracteres, ordenadas alfabéticamente.
		
		Arrays.stream(textos)
		//.sorted((a,b) -> a.length() - b.lenth())
		.sorted(Comparator.comparingInt(a->a.length()))
		.forEach(s->System.out.println(s));
		
		
		// Para concatenar comparaciones:
		Comparator<String> c1 = (a,b) -> a.length() - b.length();
		Comparator<String> c2 = c1.thenComparing((a,b) -> a.compareTo(b));
		// Este segundo comparator es el que se va a aplicar al sorted
		
		Arrays.stream(textos)
		.sorted(c2)
		.forEach(s->System.out.println(s));
		
		Arrays.stream(textos)
		.sorted(Comparator.comparingInt( (String a)->a.length()).thenComparing((a,b) -> a.compareTo(b)))
		.forEach(s->System.out.println(s));
	}

}
