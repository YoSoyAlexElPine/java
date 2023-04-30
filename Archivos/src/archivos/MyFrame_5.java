package archivos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame_5 extends JFrame implements MouseListener{
	
	JLabel label;
	
	MyFrame_5(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		
		label=new JLabel();
		label.setBounds(0,0,100,100);
		label.setBackground(Color.red);
		label.setOpaque(true);
		this.addMouseListener(this);
		
		this.add(label);
		this.setVisible(true);
	
	
	
	
	
	
	
	
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
		System.out.println("Has hecho click");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Acabas de hacer clic");
		label.setBackground(Color.yellow);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Acabas de soltar el clic");
		label.setBackground(Color.green);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Has entrado al cuadrado");
		label.setBackground(Color.blue);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Has salido del cuadrado rojo");
		label.setBackground(Color.red);
	}

}
