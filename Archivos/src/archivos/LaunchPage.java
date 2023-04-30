package archivos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LaunchPage implements ActionListener{
	JFrame frame=new JFrame();
	JButton button = new JButton("Nueva ventana");
	
	LaunchPage(){
		
		button.setBounds(100,160,200,40);
		button.setFocusable(false);
		button.addActionListener(this);
		
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setFocusable(true);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			frame.setVisible(false);
			NewWindow newWindow=new NewWindow();
		}
		
	}
}
