package principal;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sorteo {

	public static void main(String[] args) {
		String combinacionUsuario;
		int[] combinacionNumerica;
		int[] combinacionGanadora;
		int aciertos;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce tu combinación:");
		combinacionUsuario=sc.nextLine();
		//elimina duplicados en la cadena con algo del futuro:
		combinacionUsuario=Arrays.stream(combinacionUsuario.split(","))
								.distinct()
								.collect(Collectors.joining(","));
		combinacionNumerica=generarCombinacion(combinacionUsuario);
		combinacionGanadora=generarCombinacionGanadora();
		aciertos=calcularAciertos(combinacionNumerica,combinacionGanadora);
		
		//mostrar datos
		System.out.println("Combinación de usuario: "+Arrays.toString(combinacionNumerica));
		System.out.println("Combinación ganadora: "+Arrays.toString(combinacionGanadora));
		System.out.println("Aciertos: "+aciertos);
	
		//¿Cuantas veces tengo que jugar para poder conseguir 6 aciertos?
		/*long veces=0;
		combinacionNumerica= new int[]{7,13,23,36,39,42};
		do {
			//generarCombinacionGanadora();
			combinacionGanadora=generarCombinacionGanadora();
			aciertos=calcularAciertos(combinacionNumerica,combinacionGanadora);
			veces++;
		}while(aciertos<6);
		System.out.println("He tenido que jugar: "+veces+" veces");*/
		
		
	}
	static int[] generarCombinacion(String comb) {
		
		String [] valores=comb.split(",");
		int[] numeros=new int[valores.length];
		for(int i=0;i<valores.length;i++) {
			numeros[i]=Integer.parseInt(valores[i]);
		}
		return numeros;
	}
	static int[] generarCombinacionGanadora() {
		int[] generados=new int[6];
		int numero,totales=0;
		//Hay que generar un número aleatorio entre 1 y 49
		//hasta conseguir 6 diferentes
		do {
			//genero número y si no está repetido, lo guardamos
			numero=(int)(Math.random()*49+1);
			if(!repetido(generados,numero,totales)) {
				generados[totales]=numero;
				totales++;
			}
		}while(totales<6);
		Arrays.sort(generados);//ordena array de menor a mayor
		return generados;
	}
	static boolean repetido(int[] numeros, int num, int totales) {
		boolean resultado=false;
		for(int i=0;i<totales;i++) {
			if(numeros[i]==num) {//repetido
				resultado=true;
				break;
			}
		}
		return resultado;
	}
	static int calcularAciertos(int[] cNumerica, int[] cGanadora) {
		int aciertos=0;
		for(int n:cNumerica) {
			for(int g:cGanadora) {
				if(n==g) {
					aciertos++;
					break;
				}
			}
		}
		return aciertos;
	}

}
