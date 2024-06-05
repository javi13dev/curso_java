package certificacion_examen;

import java.util.stream.Stream;

public class Test10 {

	public static void main(String[] args) {
		
		Stream<String> s1 = Stream.of("A", "B", "C", "B");
		Stream<String> s2 = Stream.of("A", "D", "E");
		
		Stream.concat(s1, s2).parallel().distinct()
		.forEach(element -> System.out.println(element));
		
		/*
		 * 
		 A. ADEABCB  // the order of the element is unpredictable
		 
		 B. ABCE
		 
		 C. ABCDE // the order of the elements is unpredictable  CORRECTA
		 
		 D. ABBCDE // the order of the elements is unpredictable
		 */

	}

}
