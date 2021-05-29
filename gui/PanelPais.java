package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class PanelPais extends AbstractPanel {
	
	private Image image;
	private int numImg;
	private String[] array = {"/img/argentinaBSAS.jpg", "/img/usa.jpg", "/img/rusia.jpg"};

	public PanelPais(boolean visible, int img) {
		super(visible);
		this.numImg = img;
	}
	
	@Override
	public void paint(Graphics g) {
		image = new ImageIcon(getClass().getResource(array[numImg])).getImage();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		super.paint(g);
	}
	
}