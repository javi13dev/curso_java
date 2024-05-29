import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCaoturaDiferente {


	public static void main(String[] args) {
		 try {
			m();
		 }
		 catch(IOException ex) {
			 
		 }
		 catch(Exception ex) {
			 
		 }
		 finally {
			 
		 }

	}
	
	static void m() throws Exception{
		throw new FileNotFoundException();
	}


}
