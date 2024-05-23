
public class TestLocal {

	public static void main(String[] args) {
		
		TestLocal tl = new TestLocal();
		tl.metodo();

	}
	
	public void metodo() {
		int a = 1;
		class Local {
			void print() {
				System.out.println("Desde local"+a);
			}
		}
		
		Local l = new Local();
		l.print();
		// a++; esto daría error de compilación.
		// Si no cambiase el valor de la variable sí valdría. Se denomina Constantes efectivas(cuando no cambian)
		// Esto referido a variables locales, con las no locales no habría este problema.
		
	}

}
