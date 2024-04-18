package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import service.FuncionalesService;

public class Test {

	public static void main(String[] args) {
		// Prueba, vamos a instanciar:
		FuncionalesService service = new FuncionalesService();
		
		// Realizar una llamada a cada método service.
		// Hay que implementar las lambdas según su tipo. Cuando el parámetro es una interfaz, lo que se pasa es un objeto.
		
		
		/**
		 * 	public void m1(Set<Integer> nums, Function<String, Integer> fn) {
	
			}
		 */
		
		service.m1(Set.of(8,4,7), s->s.length());
		// La finalidad era: pasarle un set. 
		// Y en la parte del function, pasarle un string y de la forma que sea que devuelva un Integer como requeria su implementación.
		
		
		/**
		 * 	public void m2(Supplier<String> sp, Consumer<Integer> cs) {
		
			}
		 */
		

		service.m2(()-> "miString", (s)->System.out.println(s));
		
		
		/**
		 * 	public void m3(BinaryOperator<Double> db, BiFunction<Integer, String, Integer> bf ) {
		
			}
		 */
		// Con dos parámetros del mismo tipo, y que devuelve el mismo tipo.
		// Son dos datos de entrada y uno de salida, del mismo tipo.
		service.m3((a,b)-> a+b,  (a,b) -> a);
		
		/**
		 * 	public void m4(BiConsumer <String, Double> bc, BiPredicate<String, Long> bp) {
		
			}
		 */
		// Porque BiPredicate es una condición. Debe ser el resultado de una condición.
		// Compara la longitud de un long con el String.
		
		service.m4( (a,b)->System.out.println(), (c,d)-> c.length()>d);
		
		
		/**
		 * 	public void m5(IntSupplier is, List<String> lst) {
		
			}
		 */
		
		service.m5( ()-> 1, List.of("uno", "dos","tres") );
		
		
		
		/**
		 * 
		 * 	public void m6(Map <String, Integer> mp, BiConsumer<String, Long> bc) {
		
			}
		 */
		
		service.m6(Map.of("Hola", 1), (a,b)->System.out.println(a));
		
		
		
		/**
		 * 
			public void m7(Function<String, List<Integer>> fn) {
				
			}
		 */
		
		service.m7(s -> List.of(1,2,3));
	}

}
