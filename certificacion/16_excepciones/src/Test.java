
public class Test {
	public void m() {
		try {
			int a = 5;
			
		} catch (Exception e) { // Si fuera IOException no compilaría. Porque nunca se va a producir.
			// De las excepciones checked deben de poder producirse para capturarlas.
			
			// Las Runtime el compilador no las detecta.
		}
	}
}
