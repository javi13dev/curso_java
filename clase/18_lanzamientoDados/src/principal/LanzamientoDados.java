package principal;

import java.util.Random;

public class LanzamientoDados {

	public static void main(String[] args) {
		/*int dado=(int)(Math.random()*6+1);
		System.out.println(dado);*/
		//lanzará el dado muchas veces (10000) y después
		//mostraremos los porcentajes de veces que ha aparecido
		//cada número
		//lanzar el dado 10000 veces y mostraremos los porcentajes
				//de cada cara
				final int LANZAMIENTOS=100_000;
				int[] contadores=new int[6];
				var rnd=new Random();
				for(int i=1;i<=LANZAMIENTOS;i++) {
					//lanzamiento de dado
					//int dado=(int)(Math.random()*6+1);
					int dado=rnd.nextInt(6)+1;
					//siempre se incrementa la posición del array
					//cuyo índice es el valor del dado menos 1
					contadores[dado-1]++;
				}
				for(int i=0;i<contadores.length;i++) {
					System.out.println("porcentaje de "+(i+1)+": "+contadores[i]*100.0/LANZAMIENTOS);
				}

	}

}
