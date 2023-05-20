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
	
	JLabel l1,l2=new JLabel();
	
	Timer timer=new Timer(1000, null);
	
	int num=180;
	
	pruebas() throws InterruptedException {
		
		
	      /*timer = new Timer(1000, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	num--;
	                int minutos = num / 60;
	                int segundosRestantes = num % 60;
	                l2.setText(String.format("%d:%02d", minutos, segundosRestantes));
	                if (num == 0) {
	                    timer.stop();
	                    l2.setText("¡Tiempo terminado!");
	                }
	            }
	        });
		
		
		
		//l1.setText(String.valueOf(num));
	
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
		
		l2.setVisible(true);
		l2.setForeground(Color.black);

		panel1.add(l2);
		panel4.add(b1);
		panel4.add(b2);
		panel4.add(b3);
		panel5.add(l2);
		
		b1.addActionListener(this);
	      */
		
		int segundos=10;
		
		
	
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		l2.setText("180");
		l2.setFont(new Font(null,Font.BOLD,40));
		l2.setHorizontalAlignment(JLabel.CENTER);
		l2.setVerticalAlignment(JLabel.CENTER);
		
		this.add(l2);
		this.setVisible(true);
		segundos++;
		do {
			segundos--;
			l2.setText(Integer.toString(segundos));
			Thread.sleep(1000);
		} while (segundos>0);
		l2.setText("Se termino :D");
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
