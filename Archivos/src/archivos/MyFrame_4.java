package archivos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class MyFrame_4 extends JFrame implements KeyListener{

	JLabel label;
	ImageIcon icon;
	
	MyFrame_4(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		this.addKeyListener(this);
		this.setVisible(true);
		
		icon=new ImageIcon("cowboy.png");
		
		label= new JLabel();
		label.setBounds(0,0,100,100);
		//label.setBackground(Color.red);
		//label.setOpaque(true);
		label.setIcon(icon);
		
		this.getContentPane().setBackground(Color.black);
		this.add(label);
		this.setVisible(true);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 37: label.setLocation(label.getX()-10, label.getY());
			break;
		case 38: label.setLocation(label.getX(), label.getY()-10);
			break;
		case 39: label.setLocation(label.getX()+10, label.getY() );
			break;
		case 40: label.setLocation(label.getX() , label.getY()+10);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Has dejado de pulsar la tecla: "+e.getKeyChar());
		System.out.println("El codigo de la tecla es: "+e.getKeyCode());
		
	}
	
	
}
