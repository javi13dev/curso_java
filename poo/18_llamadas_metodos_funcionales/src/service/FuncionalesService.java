package service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class FuncionalesService {
	
	// Práctica común, encontrarse con clases y métodos de llamadas funcionales/lambdas
	
	public void m1(Set<Integer> nums, Function<String, Integer> fn) {
	
	}
	
	public void m2(Supplier<String> sp, Consumer<Integer> cs) {
		
	}
	
	public void m3(BinaryOperator<Double> db, BiFunction<Integer, String, Integer> bf ) {
		
	}
	
	public void m4(BiConsumer <String, Double> bc, BiPredicate<String, Long> bp) {
		
	}
	
	public void m5(IntSupplier is, List<String> lst) {
		
	}
	
	public void m6(Map <String, Integer> mp, BiConsumer<String, Long> bc) {
		
	}
	
	public void m7(Function<String, List<Integer>> fn) {
		
	}
	
}
