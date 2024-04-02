package principal;

public class PanelPremios {
	public static void main(String[] args) {
		final int FILAS=5;
		final int COLUMNAS=5;
		int [][] panel=new int[FILAS][COLUMNAS];
		int premios=0;
		int fila, columna;
		do {
			fila=(int)(Math.random()*(FILAS)); //entre 0 y 4
			columna=(int)(Math.random()*(COLUMNAS));//entre 0 y 4
			if(panel[fila][columna]!=1) {//si no está ocupada, la ocupamos
				panel[fila][columna]=1;
				premios++;
			}
		}while(premios<5);
		mostrarPanel(panel);
	}
	static void mostrarPanel(int[][] panel) {
		for(int i=0;i<panel.length;i++) {
			for(int j=0;j<panel[i].length;j++) {
				System.out.print(panel[i][j]+"|");
			}
			System.out.println();
		}
	}
}

/*
 * package principal;

import java.util.Random;

public class Panel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int premios = 5;
		int espacios = 100;
		var rnd = new Random();

		int [][] panel = new int [10][10];
		
		rellenarPanel(panel);

		

	}
	
	static void rellenarPanel(int [][] panel) {
	
		// rellenar el panel
		for (int i = 0; i < panel.length; i++) {
			for (int j = i+1; j < panel.length; j++) {
				panel[i][j] = panel[i][0];
				System.out.println(panel[i][j]);
				
			}
		}
	}

}
*/
