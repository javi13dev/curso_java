package operaciones;

// import util.Utilidades;
import static util.Utilidades.*;

public class Calculadora {
	
	public int sumar(int a, int b) {
		return a+b;
	}
	
	public int multiplicar(int a, int b) {
		return a*b;
	}
	
	// Queremos unas utilidades para controlar que el primer número 
	// sea el mayor.
	public int restar(int a, int b) {
		// return Utilidades.mayor(a,b)-Utilidades.menor(a, b);
		return mayor(a,b) - menor(a, b); // importación estática. Así podemos llamar directamente a los métodos.
	}
	
	public int dividir(int a, int b) {
		return mayor(a,b) / menor(a, b);
	}

}
