package se.mah.k3.lars.test;

import se.mah.k3.lars.model.Cat;

public class TestCat {

	/*TestClass for testing the Cat-class*/
	/* Eclipse chooses to run the file that is open here if it has a main class but it only runs one of them
	So if you press play here only this Main method will run not hte one in TestCAtGarden or the one in CatGardenGUI*/ 
	public static void main(String[] args) {
		System.out.println("Detta är en test för Cat");
		System.out.println("**Start Test");
		Cat c = new Cat();
		Cat a = new Cat("Brown","Missen");
		System.out.println("One cat: "+ c.getName()+" and one: "+ a.getName());
		System.out.println("**End Test");
	}

}
