package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.ErrorFuenteDatosException;

public class NotasService {
	
	// Las notas deben guardare en un fichero
	
	String ruta = "notas.txt";
	Path pt = Path.of(ruta);

	public void borrarNotas() {
		// Creamos un objeto File apuntando al fichero y llamar al método delete
		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarNota(double nota) {
		// Escribir en el fichero la nota que recibo
		// Método append
		try{
			Files.writeString(pt, nota+System.lineSeparator() , StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public double media() throws ErrorFuenteDatosException {
		// 2) Aqui se propaga para que se maneje poteriormente
		
		try{
			return Files.lines(pt)
			 .collect(Collectors.averagingDouble(n->Double.parseDouble(n)));
		}
		catch(IOException ex) {
			ex.printStackTrace();
			// 1) para usar nuestra Exception, se crea una y se pasa a throw
			// Es decir, provoca la Exception, y si queremos que se maneje en la capa de presentación, se hace un throws
			throw new ErrorFuenteDatosException();
		}
	}
	
	
	public double max() throws ErrorFuenteDatosException {

		try{
			/*
			return Double.parseDouble(Files.lines(pt)
					.max(Comparator.comparingDouble(n -> Double.parseDouble(n)))
					.orElse(null));
			*/
			return Files.lines(pt) // Stream<String>
					.max(Comparator.comparingDouble(n -> Double.parseDouble(n))) // Optional<String>
					.map(n -> Double.parseDouble(n)) // Optional<Double>
					.orElse(0.0);
					
		}
		catch(IOException ex) {
			ex.printStackTrace();
			throw new ErrorFuenteDatosException();
		}
	}
	
	public double min() throws ErrorFuenteDatosException {

		try{
			/*
			return Double.parseDouble(Files.lines(pt)
					.min(Comparator.comparingDouble(n -> Double.parseDouble(n)))
					.orElse(null));
			*/
			return Files.lines(pt) // Stream<String>
					.min(Comparator.comparingDouble(n -> Double.parseDouble(n))) // Optional<String>
					.map(n -> Double.parseDouble(n)) // Optional<Double>
					.orElse(0.0);
					
		}
		catch(IOException ex) {
			ex.printStackTrace();
			throw new ErrorFuenteDatosException();
		}
	}
	
	public List<Double> obtenerNotas() throws ErrorFuenteDatosException{

		try {
			return Files.lines(pt)
			.map(n -> Double.parseDouble(n))
			.toList();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ErrorFuenteDatosException();
		}

	}
}







