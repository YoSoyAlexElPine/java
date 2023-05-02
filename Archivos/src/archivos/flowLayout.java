package archivos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*	;

public class flowLayout implements ActionListener{
	JButton button2=new JButton("8");
	JFrame frame=new JFrame();
	JFrame frame2=new JFrame();
public static  void correr() {

	JFrame frame=new JFrame();
	JFrame frame2=new JFrame();
	
	frame2.setSize(100,100);
	frame2.setBackground(Color.red);
	frame2.setVisible(false);
	
	JButton button=new JButton();

	JButton button2=new JButton("8");
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500,500);
	frame.setVisible(true);
	frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
	
	JPanel panel=new JPanel();
	
	panel.setPreferredSize(new Dimension(250,250));
	panel.setBackground(Color.lightGray);
	panel.setLayout(new FlowLayout());
	
	panel.add(new JButton("1"));
	panel.add(new JButton("2"));
	panel.add(new JButton("3"));
	panel.add(new JButton("4"));
	panel.add(new JButton("5"));
	panel.add(new JButton("6"));
	panel.add(new JButton("7"));
	panel.add(button2);
	panel.add(new JButton("9"));
	panel.add(new JButton("10"));
	
	frame.add(panel);
	frame.setVisible(true);
	

}
public static void gridLayout() {
}
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource()==button2) {
		frame.dispose();
		frame2.dispose();
		frame.setVisible(false);
		frame2.setVisible(true);
	}
	
}
}
