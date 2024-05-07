package principal;

import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class TestStreamBuilder {
	public static void main (String [] args) {
		
		Stream<String> st = Stream.of("a", "b", "c");
		
		Stream.Builder<String> builder = Stream.builder();
		Stream<String> st2 = builder
						 	.add("d")
							.add("e")
							.add("f")
							.build();
	}
}
