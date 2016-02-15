package se.mah.k3.lars.model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public abstract class Tower implements MouseMotionListener{

	protected JLayeredPane gameArea;
	protected JLabel label;
	
	public Tower(JLayeredPane gameArea) {
		this.gameArea = gameArea;
		label = new JLabel("");
		gameArea.setLayer(label, 1);
		label.setLocation(0, 0);
		label.setSize(50, 50);
		label.setVisible(false);
		label.addMouseMotionListener(this);
		gameArea.add(label);
	}
	
	public void setPosition(int x, int y){
		label.setLocation(x, y);
	}
	
	public void setVisible(boolean visible){
		label.setVisible(visible);
	}
	
	public abstract void makeSound();
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int labelX = label.getX();
		int labelY = label.getY();
		label.setLocation(labelX+ e.getX(), labelY + e.getY());
		System.out.println("Dragged"+e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
