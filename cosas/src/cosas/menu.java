package cosas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu extends JFrame implements ActionListener{
	
	JLabel label=new JLabel();
	
	ImageIcon git = new ImageIcon("github.png");
	ImageIcon proceso = new ImageIcon("proceso.png");
	
	JButton buscaminas,calculadora,aimHero,contadorClick,tresRaya = new JButton();
	
	JPanel panelN=new JPanel();
	JPanel panelC=new JPanel();
	
	menu(){
		
		this.setLayout(new BorderLayout(10,10));
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420,420);
		//this.setMinimumSize(new Dimension(400,400));
		this.setIconImage(git.getImage());
		getContentPane().setBackground(Color.BLACK);

		this.setVisible(true);
		
		label.setSize(this.getWidth(), 50);
		label.setForeground(Color.white);
		label.setText("Elige opcion");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.TOP);
		label.setFont(new Font("Consolas",Font.PLAIN,35));
		label.setVisible(true);
		

		buscaminas=new boton("Buscaminas");
		buscaminas.addActionListener(this);
		
		calculadora=new boton("Calculadora");
		calculadora.addActionListener(this);
		
		aimHero = new boton("Aim Hero");
		aimHero.addActionListener(this);
		
		contadorClick=new boton("Contador Clicks");
		contadorClick.addActionListener(this);
		
		tresRaya=new boton("Tres en raya");
		tresRaya.addActionListener(this);
		
		panelN.add(label);
		panelN.setBackground(Color.black);
		panelN.setVisible(true);
		
		panelC.setBackground(Color.black);
		panelC.add(aimHero);
		panelC.add(calculadora);
		panelC.add(buscaminas);
		panelC.add(contadorClick);
		panelC.add(tresRaya);
		panelC.setLayout(new GridLayout(3,3,10,10));
		panelC.setVisible(true);

		this.add(panelN, BorderLayout.NORTH);
		this.add(panelC, BorderLayout.CENTER);
		
		panelC.setMaximumSize(new Dimension(100,100));
	
		//this.add(buscaminas);
		//this.add(calculadora);
		//this.add(aimHero);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==aimHero) {
			try {
				new aimHero();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==calculadora) {
			new Calculadora();
		}
		if(e.getSource()==buscaminas) {
			JOptionPane.showMessageDialog(null,"JUEGAZO, pero en construccion");
		}
		if(e.getSource()==contadorClick) {
			new ContadorClicks();
		}
		if(e.getSource()==tresRaya) {
			JOptionPane.showMessageDialog(
					null,
					"Juego tres taya en proceso",
					"Panel de informacion",
					JOptionPane.NO_OPTION,
					proceso
					);
		}
		
	}
}
