package principal;

import java.util.Scanner;

public class BuscarProducto {

	public static void main(String[] args) {
		String cesta="tomates patatas,vino,tomates.leche,azucar,vino,pan,vino,patatas,pan";
		//se pide la introducción de un producto, y programa nos muestra su stock
		Scanner sc=new Scanner(System.in);
		String producto;
		int stock=0;
		String[] productos=cesta.split("[ ,.]");
		System.out.println("Introduce producto: ");
		producto=sc.nextLine();//le pedimos el producto
		for(String p:productos) {
			if(p.equals(producto)) {
				stock++;
			}
		}
		System.out.println("El stock de "+producto+" es "+stock);
		
	}

}
