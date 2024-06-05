package certificacion_examen;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

class Product {
	String name;
	double price;
	Product(String s, double d){
		this.name = s;
		this.price = d;
	}
}

class ElectricProduct extends Product{
	ElectricProduct(String name, double price){
		super(name, price);
	}
}

public class Test9 {
	
	public static void main(String [] args) {
		
		
		List<Product> p = List.of(
				new ElectricProduct("CellPhone", 100),
				new ElectricProduct("ToyCar", 90),
				new ElectricProduct("Motor", 200),
				new ElectricProduct("Fan", 300)
				);
		
		DoubleSummaryStatistics sts = p.stream()
				.filter(a -> a instanceof ElectricProduct)
				.collect(Collectors.summarizingDouble(a -> a.price));
		
		String s1 = p.stream()
				.filter(a -> a instanceof Product)
				.collect(Collectors.mapping(p2 -> p2.name, Collectors.joining(",")));
		
		System.out.println(sts.getMax());
		System.out.println(s1);
		
	} 
	
	/*
	 a) 300.00
		CellPhone,ToyCar,Motor,Fan  // Correcta
		
	 b) 100.0
		CellPhone,ToyCar,Motor,Fan
		
	 c) 100.0 CellPhone,ToyCar
	 
	 d) 300.00

	 */
	
	
	
	
}
