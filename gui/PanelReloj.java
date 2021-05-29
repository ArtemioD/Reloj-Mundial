package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class PanelReloj extends AbstractPanel implements Runnable {
	
	private Thread h1;
	private int sumarHr = 0;
	
	private JLabel timeLabel;
	private JLabel dayLabel;
	private JLabel dateLabel;
	
	private String time;
	private String day;
	private String date;
	
	private String[] semana = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
	private String[] meses = {"Enero", "Febro", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	
	
	public PanelReloj() {
		super(true); // vidible
		setBackground(new Color(0, 0, 0, 128)); //
		setBounds(25, 25, 320, 180);
		setOpaque(false);
		setLayout(new FlowLayout()); 
		
		h1 = new Thread(this);
		h1.start();
		
		init();
	}

	public void init() {
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setOpaque(false);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
		dayLabel.setForeground(Color.WHITE);
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
		dateLabel.setForeground(Color.WHITE);
			
		this.add(dayLabel);
		this.add(timeLabel);
		this.add(dateLabel);			
	}


	@Override
	public void run() {
        while (true) {
        	calcular();
			dayLabel.setText(day);
			timeLabel.setText(time);
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {	
				e.printStackTrace();
				System.out.println("error PanelReloj 87");
			}
        }		
	}
	
	
	private void calcular() {
		Calendar calendar = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        calendar.setTime(fechaHoraActual);
        calendar.add(Calendar.HOUR_OF_DAY, sumarHr); //....... modifica la hora
        
        String hora = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" + 
        		calendar.get(Calendar.HOUR_OF_DAY) : "0" + calendar.get(Calendar.HOUR_OF_DAY);
        String minutos = calendar.get(Calendar.MINUTE) > 9 ? "" + 
        		calendar.get(Calendar.MINUTE) : "0" + calendar.get(Calendar.MINUTE);
        String segundos = calendar.get(Calendar.SECOND) > 9 ? "" + 
        		calendar.get(Calendar.SECOND) : "0" + calendar.get(Calendar.SECOND);
        
		time = hora + ":" + minutos + ":" + segundos;
		day = semana[calendar.get(Calendar.DAY_OF_WEEK) - 1];
		date = calendar.get(Calendar.DATE) + " de " + 
				meses[calendar.get(Calendar.MONTH)] + 
				", " + calendar.get(Calendar.YEAR);	
	}
	
	// metodo para cambia hora dependiendo del pais
	public void setSumarHr(int sumarHr) {
		this.sumarHr = sumarHr;	
	}

}
