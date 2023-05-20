package cosas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;


public class aimHero extends JFrame implements ActionListener{
	
	int segundos=60;
	
	String str1="0";
	String str2=Integer.toString(segundos);
	
	ImageIcon aim = new ImageIcon("aim.png");
	
	JPanel panelN=new JPanel();
	JPanel panelS=new JPanel();
	
	JLabel puntuacion,tiempo=new JLabel();
	JLabel cuentaAtras=new JLabel();

	JButton volver=new JButton();

	aimHero() throws InterruptedException{
		
		JPanel panelN=new JPanel();
		JPanel panelS=new JPanel();
		
		JLabel puntuacion=new JLabel();
		JLabel tiempo=new JLabel();
		
		volver=new JButton("      Volver al menu");
		volver.addActionListener(this);
		
		cuentaAtras.setHorizontalAlignment(JLabel.CENTER);
		cuentaAtras.setVerticalTextPosition(JLabel.CENTER);
		cuentaAtras.setFont(new Font(null,Font.BOLD,80));
		cuentaAtras.setVisible(true);
		
		this.setLayout(new BorderLayout(10,10));
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(getMaximumSize());
		//this.setMinimumSize(new Dimension(400,400));
		this.setIconImage(aim.getImage());
		getContentPane().setBackground(new Color(139,186,247));
		this.setVisible(true);
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		
		puntuacion.setBounds((this.getWidth()/2)-200, 0, 1000, 20);
		puntuacion.setForeground(Color.white);
		puntuacion.setText("Puntuacion: "+str1);
		
		tiempo.setBounds((this.getWidth()/2)+100, 0, 1000, 20);
		tiempo.setForeground(Color.white);
		tiempo.setText("Tiempo: "+str2);
		
		volver.setBounds(50, 5, 120, 20);

		volver.setFocusable(false);
		volver.setBorder(BorderFactory.createEmptyBorder());
		volver.setBackground(Color.gray);
		volver.setForeground(Color.white);
		volver.setHorizontalAlignment(JLabel.LEFT);
		
		panelS.setBackground(new Color(139,186,247));
		
		panelN.setLayout(null);
		panelN.setBackground(Color.black);
		panelN.setPreferredSize(new Dimension(0,30));
		panelN.add(puntuacion);
		panelN.add(tiempo);
		panelN.add(volver);
		
		this.add(panelN,BorderLayout.NORTH);
		this.add(panelS,BorderLayout.SOUTH);
		this.add(cuentaAtras);
		
		do {
			for (int i = 3; i < 0; i--) {
				cuentaAtras.setText(Integer.toString(i));
				Thread.sleep(1000);
			}
			cuentaAtras.setVisible(false);
		} while (segundos>0);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==volver) {
			this.setVisible(false);
		}
		
	}
}
