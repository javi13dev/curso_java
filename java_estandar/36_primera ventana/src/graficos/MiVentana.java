package graficos;

import java.awt.Color;

import javax.swing.JFrame;

public class MiVentana extends JFrame {
	/*
	 *  Dentro del constructor, se deberán realizar las siguientes 
		tareas. 
		 Establecimiento del título de la ventana 
		 Definir tamaño y posición 
		 Visualizar la ventana 
	 */
	
	public MiVentana() {
		super("Primera ventana swing");
		this.setBounds(100, 100, 700, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setVisible(true);
	}
}
