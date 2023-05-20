package cosas;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContadorClicks extends JFrame implements ActionListener{
	
	int contador=0;
	
	JButton sumar1=new boton("+ 1");
	JButton sumar5,sumar10,sumar100,sumar1000=new JButton();
	JButton restar1,restar5,restar10,restar100,restar1000=new JButton();
	JButton resetear=new JButton();
	JButton gotomenu=new JButton();
	
	JPanel panelN=new JPanel();
	JPanel panelC=new JPanel();
	JPanel panelS=new JPanel();
	
	JLabel titulo=new JLabel("Contrador de clicks :D");
	JLabel marcador=new JLabel("0");
	
	ImageIcon calc=new ImageIcon("calculadora.png");
	
	ContadorClicks(){
		
		this.setTitle("Contador de Clicks");
		this.setBounds(10,100,800,800);
		this.setLayout(new BorderLayout());
		this.setIconImage(calc.getImage());
		getContentPane().setBackground(Color.BLACK);
		this.setVisible(true);
		
		titulo.setFont(new Font(null,Font.BOLD,50));
		
		marcador.setFont(new Font("Consolas",Font.BOLD,60));
		marcador.setHorizontalAlignment(JLabel.CENTER);
		marcador.setVerticalAlignment(JLabel.BOTTOM);
		
		sumar1=new boton("+ 1");sumar1.setBackground(new Color(115,255,134));sumar1.addActionListener(this);
		sumar5=new boton("+ 5");sumar5.setBackground(new Color(115,255,134));sumar5.addActionListener(this);
		sumar10=new boton("+ 10");sumar10.setBackground(new Color(115,255,134));sumar10.addActionListener(this);
		sumar100=new boton("+ 100");sumar100.setBackground(new Color(115,255,134));sumar100.addActionListener(this);
		sumar1000=new boton("+ 1000");sumar1000.setBackground(new Color(115,255,134));sumar1000.addActionListener(this);
		
		restar1=new boton("- 1");restar1.setBackground(new Color(255,88,88));restar1.addActionListener(this);
		restar5=new boton("- 5");restar5.setBackground(new Color(255,88,88));restar5.addActionListener(this);
		restar10=new boton("- 10");restar10.setBackground(new Color(255,88,88));restar10.addActionListener(this);
		restar100=new boton("- 100");restar100.setBackground(new Color(255,88,88));restar100.addActionListener(this);
		restar1000=new boton("- 1000");restar1000.setBackground(new Color(255,88,88));restar1000.addActionListener(this);
		
		gotomenu=new boton("Goto menu");
		gotomenu.addActionListener(this);
		
		resetear=new boton("Resetear");
		resetear.addActionListener(this);
		
		panelN.add(titulo);titulo.setForeground(Color.white);
		panelN.setBackground(Color.black);
		
		panelC.add(marcador);marcador.setForeground(Color.white);
		panelC.setBackground(Color.black);
		panelC.setPreferredSize(new Dimension(0,50));
		panelC.setLayout(new FlowLayout());
		
		panelS.setPreferredSize(new Dimension(0,500));
		
		
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
		panelS.add(gotomenu);
		panelS.setBackground(Color.black);
		panelS.setLayout(new GridLayout(3,3,10,10));
		
		panelC.setBackground(Color.black);
		
		this.add(panelN, BorderLayout.NORTH);
		this.add(panelC, BorderLayout.CENTER);
		this.add(panelS, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==restar1) {
			contador--;
		}
		if (e.getSource()==sumar1) {
			contador++;
		}
		if (e.getSource()==restar5) {
			contador=contador-5;
		}
		if (e.getSource()==restar10) {
			contador=contador-10;
		}
		if (e.getSource()==restar100) {
			contador=contador-100;
		}
		if (e.getSource()==restar1000) {
			contador=contador-1000;
		}
		if (e.getSource()==sumar5) {
			contador=contador+5;
		}
		if (e.getSource()==sumar10) {
			contador=contador+10;
		}
		if (e.getSource()==sumar100) {
			contador=contador+100;
		}
		if (e.getSource()==sumar1000) {
			contador=contador+1000;
		}
		if(e.getSource()==resetear) {
			contador=0;
		}
		if(e.getSource()==gotomenu) {
			this.setVisible(false);
		}
		marcador.setText(Integer.toString(contador));
	}
}
