package cosas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class boton extends JButton{

	/**
	 * 
	 */
	boton (String titulo) {
		this.setText(titulo);
		this.setBackground(Color.white);
		this.setForeground(Color.black);
		this.setFocusable(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

}
