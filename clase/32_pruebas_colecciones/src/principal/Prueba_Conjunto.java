package principal;

import java.util.HashSet;

public class Prueba_Conjunto {

	public static void main(String[] args) {
		HashSet <Double> nums = new HashSet<Double>();
		
		nums.add(10.4);
		nums.add(20.5);
		nums.add(10.8);
		
		for(Double n:nums) {
			System.out.println(n);
		}
		
		for(Double n:nums) {
			n=n+1;
			System.out.println(n);
		}
	}
}