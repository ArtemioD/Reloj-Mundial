package gui;

import javax.swing.JPanel;

public abstract class AbstractPanel extends JPanel {
	
	public AbstractPanel(boolean visible){
        super();
        setLayout(null);
        setVisible(visible);
        setBounds(0, 0, 666, 500);
        setOpaque(false);
    }
}
