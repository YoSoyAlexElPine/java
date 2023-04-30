package archivos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame_2  extends JFrame implements ActionListener{
	
	JButton button;
	JTextField textField;
	
	MyFrame_2(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Subir");
		button.addActionListener(this);
		
		textField=new JTextField();
		textField.setPreferredSize(new Dimension(250,40));		
		textField.setFont(new Font("Consolas",Font.PLAIN,35));
		textField.setForeground(new Color(0x00FF00));
		textField.setBackground(Color.black);
		textField.setCaretColor(Color.white);
		textField.setText("Nombre de usuario");
		
		
		
		
		this.add(button);
		this.add(textField);
		this.pack();
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println("hola "+textField.getText());
			
		}
	}

}
