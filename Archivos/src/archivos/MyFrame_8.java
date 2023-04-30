package archivos;

import javax.swing.JFrame;

public class MyFrame_8 extends JFrame {
	
	MyPanel_2 panel;
	
	MyFrame_8(){
		
		panel= new MyPanel_2();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
}
