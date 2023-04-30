package archivos;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MyFrame_3 extends JFrame implements ActionListener{
	
	JButton button; 
	JCheckBox checkBox;
	ImageIcon xIcon;
	ImageIcon checkIcon;
	
	MyFrame_3(){
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new FlowLayout());
	this.setSize(500,500);
	
	xIcon=new ImageIcon("feliz.png");
	checkIcon = new ImageIcon("besito.png");
	
	button = new JButton();
	button.setText("Subir");
	button.addActionListener(this);
	
	checkBox= new JCheckBox();
	checkBox.setText("No soy un robot");
	checkBox.setFocusable(false);
	checkBox.setFont(new Font("Consolas",Font.PLAIN,25));
	checkBox.setIcon(xIcon);
	checkBox.setSelectedIcon(checkIcon);
	
	this.add(checkBox);
	this.pack();
	this.setVisible(true);
	
	
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println();
		}
	}

}
