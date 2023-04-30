package archivos;

import javax.swing.JFrame;

public class MyFrame_6 extends JFrame{
	
	DragPanel dragPanel = new DragPanel();
	
	MyFrame_6(){
		
		this.add(dragPanel);
		this.setTitle("Drag y Drop demo");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
	
}
