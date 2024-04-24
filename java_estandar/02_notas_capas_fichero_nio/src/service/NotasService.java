package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NotasService {
	
	// Las notas deben guardare en un fichero
	
	String ruta = "notas.txt";
	Path pt = Path.of(ruta);
	
	// Método nuevo, borrarNotas, eliminar el archivo
	public void borrarNotas() {
		// Creamos un objeto File apuntando al fichero y llamar al método delete
		File file = new File("fichero");
		file.delete();
	}
	
	public void agregarNota(double nota) {
		// Escribir en el fichero la nota que recibo
		// Método append
		try{
			Files.writeString(pt, String.valueOf(nota) , StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public double media() {
		
		try{
			return Files.lines(pt)
			 .collect(Collectors.averagingDouble(n->Double.parseDouble(n)));

		}
		catch(IOException ex) {
			ex.printStackTrace();
			return 0.0;
		}
	}
	
	
	
	public double max() {

		try{
			return Double.parseDouble(Files.lines(pt)
					.max(Comparator.comparingDouble(n -> Double.parseDouble(n)))
					.orElse(null));

		}
		catch(IOException ex) {
			ex.printStackTrace();
			return 0.0;
		}
		
	}
	
	public double min() {
		// inicializamos al valor máximo de un double
		// por si el fichero está vacío, siempre va a poder comparar con este valor inicial
		// Por tanto, si devuelve el MAX_VALUE , me indica que no había ninguna nota en el fichero
		double min = Double.MAX_VALUE;
		String linea;

		// Leo la nota, la guardo en un array
		try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				if(Double.parseDouble(linea) < min){
					min= Double.parseDouble(linea);
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return min;
	}
	
	
	/**
	 * 
	public double min() {
		// tengo que guardar notas en array
		double menor=notas.get(0);
		for(Double n:notas) {
			if(n<menor) {
				menor=n;
			}
		}
		return menor;
	}
	 */
	
	public List<Double> obtenerNotas(){
		ArrayList<Double> aux = new ArrayList<Double>();
		String linea;

		// Leo la nota, la guardo en un array
		try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				aux.add(Double.parseDouble(linea));
				
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return aux;
	}


}
