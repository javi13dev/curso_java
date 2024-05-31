package pruebas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class MarkTest {
    public static void main(String[] args) {
    	try {
			FileWriter f = new FileWriter("test.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try (Reader r = new BufferedReader(new FileReader("test.txt"))) {
            if (r.markSupported()) {
                BufferedReader in = (BufferedReader) r;
                System.out.print(in.readLine());
                in.mark(100);
                System.out.print(in.readLine());
                System.out.print(in.readLine());
                in.reset();                   
                System.out.print(in.readLine());
                in.reset();                     
                System.out.println(in.readLine());
            }else{
                System.out.println("Mark Not Supported");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}