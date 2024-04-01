package principal;

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
