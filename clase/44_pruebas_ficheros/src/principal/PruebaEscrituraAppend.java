package principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PruebaEscrituraAppend {

	public static void main(String[] args) {
		//String ruta="c:\\temp\\dias.txt";
		String ruta="dias.txt";
		
		//clasica
		/*FileOutputStream fos=null;
		PrintStream out=null;
		try {
			fos=new FileOutputStream(ruta, true);
			out=new PrintStream(fos);
			out.println("lunes");
			out.println("martes");
			out.println("miércoles");
			System.out.println("Información almacenada en el fichero");
			
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		finally {
			try {
				if(fos!=null) {
					fos.close();
				}
			}
			
			if(out!=null) {
				out.close();
			}
		}
		*/
		
		//con try con recursos
		try(FileOutputStream fos=new FileOutputStream(ruta, true);
				PrintStream out=new PrintStream(fos);){
			out.println("lunes");
			out.println("martes");
			out.println("miércoles");
			System.out.println("Información almacenada en el fichero");
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
