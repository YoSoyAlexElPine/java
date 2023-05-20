package archivos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;
public class jframe {
public static void label() {
	
	JLabel label=new JLabel();
	JFrame frame=new JFrame();
	Border border=BorderFactory.createLineBorder(Color.green,3);
	
	ImageIcon image=new ImageIcon("logo.png");
	ImageIcon imageCalavera=new ImageIcon("calavera_2.png");
	
	label.setText("Bro, he thinks he pay the rents");
	label.setIcon(imageCalavera);
	label.setHorizontalTextPosition(JLabel.CENTER);
	label.setVerticalTextPosition(JLabel.TOP);
	label.setIconTextGap(50);
	label.setForeground(Color.green);
	label.setFont(new Font ("MV Boli",Font.PLAIN,20));
	label.setBackground(Color.black);
	label.setOpaque(true);
	label.setBorder(border);
	label.setVerticalAlignment(JLabel.CENTER);
	label.setHorizontalAlignment(JLabel.CENTER);
	//label.setBounds(100, 100, 350, 350);
	
	
	frame.setTitle("Aqui va el titulo");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//frame.setLayout(null);
	//frame.setSize(420,440);
	frame.setVisible(true);
	frame.setIconImage(image.getImage());
	frame.add(label);
	frame.pack();
	
}
public static void panels() {
	
	ImageIcon icon=new ImageIcon("carita.png");
	
	JLabel label=new JLabel();
	label.setText("Good morning");
	label.setIcon(icon);
	label.setVerticalAlignment(JLabel.BOTTOM);
	label.setHorizontalAlignment(JLabel.RIGHT);
	label.setBounds(0,0,75,75);
	
	JPanel redPanel=new JPanel();
	
	redPanel.setBackground(Color.red);
	redPanel.setBounds(0,0,250,250);
	redPanel.setLayout(null);
	
	JPanel greenPanel=new JPanel();
	
	greenPanel.setBackground(Color.green);
	greenPanel.setBounds(0,250,500,250);
	greenPanel.setLayout(null);
	
	JPanel bluePanel=new JPanel();
	
	bluePanel.setBackground(Color.blue);
	bluePanel.setBounds(250,0,250,250);
	bluePanel.setLayout(null);

	
	
	JFrame frame=new JFrame();
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	frame.setSize(750,750);
	frame.setVisible(true);
	frame.setBackground(Color.black);
	bluePanel.add(label);
	frame.add(redPanel);
	frame.add(bluePanel);
	frame.add(greenPanel);
}

public static void boton() {
	//MyFrame frame=new MyFrame();
}

}
