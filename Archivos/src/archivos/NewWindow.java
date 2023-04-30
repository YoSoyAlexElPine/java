package archivos;

import java.awt.Font;

import javax.swing.*;

public class NewWindow {
	
	JFrame frame=new JFrame();
	JLabel label = new JLabel("Buenos dias");
	
	NewWindow(){
		
		label.setBounds(0,0,150,50);
		label.setFont(new Font(null,Font.PLAIN,20));
		
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setFocusable(true);
		frame.setVisible(true);
	}
}
