package cosas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class pruebas extends JFrame implements ActionListener{

	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	
	JButton b1 = new JButton("Boton 1");
	JButton b2= new JButton("Boton 1");
	JButton b3= new JButton("Boton 1");
	
	JLabel l1=new JLabel();
	
	int num=0;
	
	pruebas() {
		

		
		l1.setText(String.valueOf(num));
	
		JFrame frame=new JFrame();
		
		JPanel panel1=new JPanel();
		JPanel panel4=new JPanel();
		JPanel panel5=new JPanel();
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setLayout(new BorderLayout());
		
		panel1.setBackground(Color.red);
		panel4.setBackground(Color.green);
		panel5.setBackground(Color.blue);
		
		panel5.setLayout(new FlowLayout());
		
		panel1.setPreferredSize(new Dimension(100,100));
		panel4.setPreferredSize(new Dimension(200,200));
		panel5.setPreferredSize(new Dimension(100,100));
		
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel4, BorderLayout.SOUTH);
		frame.add(panel5,BorderLayout.CENTER);

		panel1.add(l1);
		panel4.add(b1);
		panel4.add(b2);
		panel4.add(b3);
		
		b1.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			num=num+1000000;
			l1.setText(Integer.toString(num));
		}
		
	}
	
	
}
