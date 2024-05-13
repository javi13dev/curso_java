package principal;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		
		List<Integer> nums = List.of(5,11,4,-22,3,11,5,9,4,6,-3,3,-8,30,40);
		
		LocalTime t1 = LocalTime.now();
		
		nums.parallelStream()
		.peek(System.out::println)
		.anyMatch(n -> n>20);
		
		LocalTime t2 = LocalTime.now();
		
		Duration d = Duration.between(t1, t2);
		System.out.println(d);
	}
}
