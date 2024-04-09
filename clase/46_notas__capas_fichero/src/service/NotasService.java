package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class NotasService {
	
	// Las notas deben guardare en un fichero
	
	String fichero = "notas.txt";
	
	// Método nuevo, borrarNotas, eliminar el archivo
	public void borrarNotas() {
		// Creamos un objeto File apuntando al fichero y llamar al método delete
		File file = new File("fichero");
		file.delete();
	}
	
	public void agregarNota(double nota) {
		// Escribir en el fichero la nota que recibo
		// Método append
		try(FileOutputStream fos=new FileOutputStream(fichero, true);
			PrintStream out=new PrintStream(fos);){
			out.println(nota);
			System.out.println("Información almacenada en el fichero");
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public double media() {
		double media=0;
		int cont=0; // Para llevar la cuenta de las lineas leidas
		// En lugar del for será un bufferreader para ir leyendo y acumulando
		// y parsearlo
		String linea;
		
		try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				cont++;
				media += Double.parseDouble(linea);
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return cont>0?media/cont:0; // Para controlar que al menos haya una nota.
	}
	
	/**
	 * 
	public double max() {
		Double [] notas = new Double [10];
		int i = 0;
		String linea;
		double mayor=notas[0];
		
		// Leo la nota, la guardo en un array
		try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				
				notas[i] = Double.parseDouble(linea);
				i++;
			}
			// recorro el array de notas y me quedo con el valor máximo
			for(Double n:notas) {
				if(n>mayor) {
					mayor=n;
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return mayor;
	}
	 */
	
	public double max() {
		double max = 0;
		String linea;

		// Leo la nota, la guardo en un array
		try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				if(Double.parseDouble(linea) > max){
					max= Double.parseDouble(linea);
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return max;
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
	
	public ArrayList<Double> obtenerNotas(){
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
