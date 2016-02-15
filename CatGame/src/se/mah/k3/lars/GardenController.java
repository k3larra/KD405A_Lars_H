package se.mah.k3.lars;

import java.util.ArrayList;
import java.util.Random;

import se.mah.k3.lars.model.BarbedWire;
import se.mah.k3.lars.model.Cat;
import se.mah.k3.lars.model.CatFarm;
import se.mah.k3.lars.model.Electric;
import se.mah.k3.lars.model.Hay;
import se.mah.k3.lars.model.Tower;

public class GardenController {
	private CatFarm catFarm;
	private CatGardenGUI catGardenGUI;
	private Cat testCat;
	
	public GardenController(CatGardenGUI catGardenGUI) {
		this.catGardenGUI = catGardenGUI;
		testCat = new Cat(catGardenGUI.getGameArea(),"green","Linn");
		catFarm = new CatFarm("Mor Anna 8");
		//Create some cats and add them to cats
		for (int i = 0; i < 20; i++) {
			//Create a Cat
			Cat d = new Cat(catGardenGUI.getGameArea(),"green","Olle"+i);
			//Get a random age by an instance of the Random Class
			Random r = new Random();
			//And ask it to deliver a int from 0-300
			int age = r.nextInt(300);
			int randX = r.nextInt(600);
			int randY = r.nextInt(400);
			d.setLocation(randX, randY);
			d.setAge(age);
			catFarm.addCat(d);
		}
		
		//Print them
		catGardenGUI.getOutputTextArea().setText(catFarm.getCats());
		
		//The towers
		BarbedWire bw = new BarbedWire(catGardenGUI.getGameArea()); 
		bw.setPosition(100, 50);
		bw.setVisible(true);
		bw.makeSound();
		
		Electric electric = new Electric(catGardenGUI.getGameArea());
		electric.setPosition(50, 100);
		electric.setVisible(true);
		electric.makeSound();
		
		Hay hay = new Hay(catGardenGUI.getGameArea());
		hay.setPosition(100, 100);
		hay.setVisible(true);
		hay.makeSound();
		
		//And declared as a Tower
		Tower t = new Hay(catGardenGUI.getGameArea());
		t.setPosition(10, 10);
		t.setVisible(true);
		t.makeSound();
		
		//Lets make a Arraylist for towers o play some sounds 
		ArrayList<Tower> myTowers = new ArrayList<Tower>();
		myTowers.add(bw);
		myTowers.add(hay);
		myTowers.add(electric);
		myTowers.add(t);
		/*MoveThread thread = new MoveThread();
		thread.start();*/
		new MoveThread().start();
	}

	public CatFarm getCatFarm(){
		return catFarm;
	}
	
	private class MoveThread extends Thread{
		@Override
		public void run() {
			while (true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
				testCat.moveCat();
				ArrayList<Cat> allCats = catFarm.getAllCats();
				for (Cat cat : allCats) {
					cat.moveCat();
				}
			}
		}
	}
}
