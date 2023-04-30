package archivos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	
	JButton boton;
	JLabel label;
	
	MyFrame(){
		
		ImageIcon icon=new ImageIcon("carita.png");
		ImageIcon icon2=new ImageIcon("besito.png");
		
		label=new JLabel();
		label.setIcon(icon2);
		label.setBounds(150,250,150,150);
		label.setVisible(false);
		
		
		boton=new JButton();
		boton.setBounds(100, 100, 300, 150);
		boton.addActionListener(this);
		boton.setFocusable(false);
		boton.setText("Pulsa el boton");
		boton.setIcon(icon);
		boton.setHorizontalTextPosition(JButton.CENTER);
		boton.setVerticalTextPosition(JButton.BOTTOM);
		boton.setFont(new Font("Comic sans",Font.BOLD,25));
		boton.setIconTextGap(-5);
		boton.setForeground(Color.cyan);
		boton.setBackground(Color.LIGHT_GRAY);
		boton.setBorder(BorderFactory.createEtchedBorder());
		
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		this.setVisible(true);
		this.add(boton);
		this.add(label);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boton) {
			//System.out.println("No pulses el boton");
			label.setVisible(true);
		}
		
	}
}
