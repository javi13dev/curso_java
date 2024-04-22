package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class NotasService {
	ArrayList<Double> notas=new ArrayList<Double>();
	
	public void agregarNota(double nota) {
		notas.add(nota);
	}
	public double media() {
		return notas.stream()
		.mapToDouble(n -> n)
		.average()
		.orElse(0);
	}
	
	// Con collector:
	public double media2() {
		return notas.stream()
				.collect(Collectors.averagingDouble(n->n));
	}// Si está vacio devuelve 0
	
	
	
	
	public double max() {
		return notas.stream()
		.mapToDouble(n -> n)
		.max()
		.orElse(0);
	}
	
	// Con collector:
	public double max2() {
		return notas.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(n->n)))
				.orElse(0.0);
	}
	
	public double min() {
		return notas.stream()
		.mapToDouble(n -> n)
		.min()
		.orElse(0);
	}
	
	// Con collector:
	public double min2() {
		return notas.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(n->n)))
				.orElse(0.0);
	}
	
	
	public int totalAprobados() {
		return (int) notas.stream()
				.filter(n -> n>5)
				.count();
	}
	
	// Con collector:
	public int totalAprobados2() {
		return notas.stream()
				.collect(Collectors.filtering(n -> n>=5, Collectors.counting())).intValue();
	}
	
	
	
	
	public Double[] obtenerNotas() {
		/*double[] todas=new double[notas.size()];
		for(int i=0;i<notas.size();i++) {
			todas[i]=notas.get(i);
		}
		return todas;*/
		return notas.toArray(new Double[0]);
	}
}
