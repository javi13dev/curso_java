package principal;

import java.util.Scanner;

public class Presupuesto {

	public static void main(String[] args) {
		//dado los datos de coches, se le pedirá
		//al cliente cual es su presupuesto y programa indicará
		//los coches a los que puede optar
		var coches= new String[]{"volvo-19_500","Audi A1-23_450","Toyota-17_300","Bmw-33_500","Mercedes-25_340","Mini-41_800"};
		var sc=new Scanner(System.in);
		double presupuesto;
		System.out.println("Dime tu presupuesto");
		presupuesto=sc.nextDouble();
		for(var coche:coches) {
			coche=coche.replace("_", "");
			int pos=coche.indexOf("-");//posición del separador
			String marca=coche.substring(0,pos);
			double precio=Double.parseDouble(coche.substring(pos+1, coche.length()));
			if(presupuesto>=precio) {
				System.out.println("Te puedes comprar un "+marca);
			}
		}
		
	}

}
