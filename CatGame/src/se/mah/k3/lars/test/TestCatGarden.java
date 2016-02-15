package se.mah.k3.lars.test;

import java.util.Random;

import se.mah.k3.lars.model.Cat;
import se.mah.k3.lars.model.CatFarm;

public class TestCatGarden {

	/*TestClass for testing the CatGarden*/
	public static void main(String[] args) {
		/* Eclipse chooses to run the file that is open here if it has a main class but it only runs one of them
		So if you press play here only this Main method will run not the one in TestCat or the one in CatGardenGUI*/ 
		//Create the garden
		CatFarm garden = new CatFarm("Little Annas Garden");
		//Add one Cat 
		Cat g = new Cat("red","Olle");
		garden.addCat(g);
		 //Try to add 500 cats only the first 99 will be added
		for (int i = 0; i < 100; i++) {
			//Make them all green but with a number after the name so we can separate them
			Cat d = new Cat("green","Olle"+i);
			//Give them some random age to test the limits on the age
			Random r = new Random();
			int age = r.nextInt(300);
			d.setAge(age);
			//And finally add them to the ArrayList
			garden.addCat(d);
		}
		//PRint it all out
		System.out.println(garden.getCats());
	}

}
