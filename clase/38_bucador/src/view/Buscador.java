package view;

import java.util.HashSet;
import java.util.Scanner;

import model.Direccion;
import service.BuscadorService;

public class Buscador {

	public static void main(String[] args) {
		
		HashSet<Direccion> direccion = new HashSet<Direccion>();
		BuscadorService service = new BuscadorService();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una tematica: ");
		String tematica = sc.nextLine();
		
		direccion = service.buscarDireccion(tematica);
		
		for(Direccion d:direccion) {
			System.out.println("Dirección: " + d.getDescripcion() + ", temática: " + d.getTematica() + ", Url: " + d.getUrl());
		}
	}
}
