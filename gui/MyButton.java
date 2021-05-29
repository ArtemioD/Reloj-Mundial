package gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;


public class MyButton extends JButton {
	
	public MyButton(int x, int y, int w, int h, String nombre) {
		super(nombre);
		setBounds(x, y, w, h); // la posicion(x, y) y tamanio(w, h)
		setFont(new Font("cooper black", 2, 25));
		setFocusable(false);
		setBackground(new Color(0, 0, 0)); //
		setOpaque(true); // permiso para poder cambiar el fondo(depende de version java) {false para quitar el fondo}
		setForeground(Color.BLACK); // color de las letras
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // cursor de la manita
		setBorderPainted(false);
		setContentAreaFilled(false); // quita el color azul que esta al presionar !!!!	
	}

}
