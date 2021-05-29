package gui;

import java.awt.Color;

public class MyPanel extends AbstractPanel {
	
	private MyButton btnAR, btnEU, btnRU;
	private PanelReloj reloj;

	public MyPanel() {
		super(true); // visible
		
		init();
	}

	private void init() {
		reloj = new PanelReloj();
		btnAR = new MyButton(0, 380, 216, 80, "ARGENTINA");
		btnEU = new MyButton(216, 380, 216, 80, "EEUU");
		btnRU = new MyButton(432, 380, 216, 80, "RUSIA");
		
		btnAR.setEnabled(false); // botton desabilitado
		
		this.add(reloj);
		this.add(btnAR);
		this.add(btnEU);
		this.add(btnRU);		
	}
	
	public MyButton getBtnAR() {
		return btnAR;
	}

	public MyButton getBtnEU() {
		return btnEU;
	}

	public MyButton getBtnRU() {
		return btnRU;
	}

	public void setHora(int hora) {
		reloj.setSumarHr(hora); // cambia la hora dependiendo del pais
	}	
}
