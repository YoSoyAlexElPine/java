package cosas;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContadorClicks extends JFrame{
	
	JButton sumar1=new JButton();
	JButton sumar5=new JButton();
	JButton sumar10=new JButton();
	JButton sumar100=new JButton();
	JButton sumar1000=new JButton();
	
	JButton restar1=new JButton();
	JButton restar5=new JButton();
	JButton restar10=new JButton();
	JButton restar100=new JButton();
	JButton restar1000=new JButton();
	
	JButton resetear=new JButton();
	
	JPanel panelN=new JPanel();
	JPanel panelC=new JPanel();
	JPanel panelS=new JPanel();
	
	JLabel titulo=new JLabel("Contrador de clicks :D");
	
	ContadorClicks(){
		this.setTitle("Contador de Clicks");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(10,100,420,420);
		this.setLayout(new BorderLayout());
		getContentPane().setBackground(Color.BLACK);
		this.setVisible(true);
		
		sumar1=new boton("+ 1");
		sumar5=new boton("+ 5");
		sumar10=new boton("+ 10");
		sumar100=new boton("+ 100");
		sumar1000=new boton("+ 1000");
		
		restar1=new boton("- 1");
		restar5=new boton("- 5");
		restar10=new boton("- 10");
		restar100=new boton("- 100");
		restar1000=new boton("- 1000");
		
		panelN.add(titulo);
		panelS.add(sumar1);
		panelS.add(sumar5);
		panelS.add(sumar10);
		panelS.add(sumar100);
		panelS.add(sumar1000);
		panelS.add(restar1);
		panelS.add(restar5);
		panelS.add(restar10);
		panelS.add(restar100);
		panelS.add(restar1000);
		panelS.add(resetear);
		
		this.add(panelN, BorderLayout.NORTH);
		this.add(panelC, BorderLayout.CENTER);
		this.add(panelS, BorderLayout.SOUTH);
		
	}
}
