package archivos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MyPanel_2 extends JPanel implements ActionListener{
	
	final int PANEL_WIDTH=500;
	final int PANEL_HEIGHT=500;
	Image enemy;
	Image backgroundImage;
	Timer timer;
	int xVelocity=3; 
	int yVelocity=1; 
	int x=0;
	int y=0;
	
	MyPanel_2(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.setBackground(Color.black);
		backgroundImage=new ImageIcon("espacio.png").getImage();
		enemy=new ImageIcon("hot.png").getImage();
		timer=new Timer(1,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		
		super.paint(g); 
		
		Graphics2D g2D=(Graphics2D) g;
		g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(enemy, x, y, null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(x>=PANEL_WIDTH-enemy.getWidth(null) || x<0) {
			xVelocity=xVelocity*-1;
		}
		
		x=x+xVelocity;
		
		if(y>=PANEL_WIDTH-enemy.getHeight(null) || y<0) {
			yVelocity=yVelocity*-1;

		}
		
		y=y+yVelocity;
		repaint();
		
	}
	
	
}
