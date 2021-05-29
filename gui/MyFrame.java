package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MyFrame extends JFrame implements ActionListener { //
	
	private MyPanel panelM;
	private PanelPais panelAR, panelEU, panelRU;
	
	public MyFrame() {
		super("ReloMun");
		setIconImage(new ImageIcon(getClass().getResource("/img/mundo2.png")).getImage());
		setLayout(null);
		setSize(666, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		init();
	}
	
	private void init() {
		panelM = new MyPanel();
		panelAR = new PanelPais(true, 0);
		panelEU = new PanelPais(false, 1);
		panelRU = new PanelPais(false, 2);
		
		panelM.getBtnAR().addActionListener(this);
		panelM.getBtnEU().addActionListener(this);
		panelM.getBtnRU().addActionListener(this);
		
		this.add(panelM);
		this.add(panelAR);
		this.add(panelEU);
		this.add(panelRU);	
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object botonPulsado = e.getSource();
		if (botonPulsado == panelM.getBtnAR()) {
			cambiarColor(1); // cambia color de letra depende de imagen
			//System.out.println("argentina");
			panelM.setHora(0); // cambia la hora dependiendo del pais
			mostrar(true, false, false);	
			desabilitarBtn(false, true, true);
		}else if (botonPulsado == panelM.getBtnEU()) {
			cambiarColor(2); // cambia color de letra depende de imagen
			//System.out.println("eeuu");
			panelM.setHora(-1); // cambia la hora dependiendo del pais
			mostrar(false, true, false);
			desabilitarBtn(true, false, true);
		}else if (botonPulsado == panelM.getBtnRU()) {
			cambiarColor(3); // cambia color de letra depende de imagen
			//System.out.println("rusia");
			panelM.setHora(6); // cambia la hora dependiendo del pais
			mostrar(false, false, true);
			desabilitarBtn(true, true, false);
		}	
	}
	
	private void desabilitarBtn(boolean ar, boolean eu, boolean ru) {
		panelM.getBtnAR().setEnabled(ar);
		panelM.getBtnEU().setEnabled(eu);
		panelM.getBtnRU().setEnabled(ru);	
	}

	private void mostrar(boolean ar, boolean eu, boolean ru) {	
        panelAR.setVisible(ar);
        panelEU.setVisible(eu);
        panelRU.setVisible(ru);   
    }
	
	private void cambiarColor(int cambio) {
	
		if(cambio == 1) {
			panelM.getBtnAR().setForeground(Color.BLACK);
			panelM.getBtnEU().setForeground(Color.BLACK);
			panelM.getBtnRU().setForeground(Color.BLACK);
		}else if(cambio == 2) {
			panelM.getBtnAR().setForeground(Color.WHITE);
			panelM.getBtnEU().setForeground(Color.BLACK);
			panelM.getBtnRU().setForeground(Color.BLACK);
		}else {
			panelM.getBtnAR().setForeground(Color.WHITE);
			panelM.getBtnEU().setForeground(Color.WHITE);
			panelM.getBtnRU().setForeground(Color.WHITE);
		}
	}

}
