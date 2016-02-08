package se.mah.k3.lars.towers;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Tower {
	protected JPanel gameArea;
	protected JLabel label;
	
	public Tower(JPanel gameArea) {
		this.gameArea = gameArea;
		label = new JLabel("No Image");
		label.setLocation(0, 0);
		label.setSize(50, 50);
		label.setVisible(false);
		gameArea.add(label);
	}
	
	public void setPosition(int x, int y){
		label.setLocation(x, y);
	}
	
	public void setVisible(boolean visible){
		label.setVisible(visible);
	}
	
	public abstract void makeSound();

}
