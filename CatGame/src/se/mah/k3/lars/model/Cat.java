package se.mah.k3.lars.model;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import se.mah.k3.lars.CatGardenGUI;
import se.mah.k3.lars.Constants;

public class Cat {
	private String color= Constants.STANDARD;
	private String name ="noname";
	private JLayeredPane gameArea;
	private int age = 0;
	private JLabel label;
	private static int MAX_AGE=220; //Age in months
	private int speedX = 1;
	private int speedY = 1;
	private Random rand = new Random();
	
	//Constructors
	
	/**Creates a cat with name Knodden*/
	public Cat(){
		this.name = "Knodden";
	}
	
	
	public Cat(String color, String name){
		this.color = color;
		this.name = name;
	}
	
	public Cat(JLayeredPane gameArea,String Color, String name ){
		this.color = color;
		this.gameArea = gameArea;
		this.name = name;
		label = new JLabel("");
		gameArea.setLayer(label, 1);
		label.setLocation(0, 0);
		label.setSize(50, 50);
		label.setVisible(true);
		int i = rand.nextInt(4);
		if (i == 1){
		 label.setIcon(new ImageIcon(CatGardenGUI.class.getResource("/images/cat1.jpg")));
		}else if (i == 2){
			 label.setIcon(new ImageIcon(CatGardenGUI.class.getResource("/images/cat2.jpg")));
		}else if (i == 3){
			 label.setIcon(new ImageIcon(CatGardenGUI.class.getResource("/images/cat3.jpg")));
		}else{
			label.setIcon(new ImageIcon(CatGardenGUI.class.getResource("/images/cat4.jpg")));
		}
		gameArea.add(label);
	}
	//Methods
	
	public void hideCat() {
		label.setVisible(false);
	}
	public void setLocation(int x, int y){
		label.setLocation(x, y);
	}
	public String getColor(){
		return this.color;
	}
	
	public String getName(){
		return this.name;
	}
	
	/**Sets the age between 0 and 220 months*/
	public void setAge(int age){
		if (age>0 && age <= MAX_AGE){
			this.age = age;
		}
	}
	
	
	public int getAge(){
		return this.age;
	}
	
	public void moveCat(){
		Point p = label.getLocation();
		int nextX = p.x + speedX;
		int nextY = p.y + speedY;
		label.setLocation(nextX, nextY);
		if (nextX > gameArea.getWidth()){
			speedX = - rand.nextInt(5);
		}
		if (nextY > gameArea.getHeight()){
			speedY = - rand.nextInt(5);
		}
		if (nextX < 0){
			speedX = + rand.nextInt(2);
		}
		if (nextY < 0){
			speedY = + rand.nextInt(2);
		}
	}

}
