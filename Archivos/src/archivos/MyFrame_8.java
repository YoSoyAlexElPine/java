package archivos;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame_8 extends JFrame {
	
	MyPanel_2 panel;
	ImageIcon image=new ImageIcon("House.png");
	MyFrame_8(){
		
		this.setIconImage(image.getImage());
		
		panel= new MyPanel_2();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
}
