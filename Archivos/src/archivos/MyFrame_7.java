package archivos;

import java.awt.*;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class MyFrame_7 extends JFrame{
	
	MyPanel panel;
	
	
	MyFrame_7(){
		
		panel=new MyPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	}
	
	
}
