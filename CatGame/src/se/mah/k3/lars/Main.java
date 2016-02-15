package se.mah.k3.lars;

import java.awt.EventQueue;



public class Main {
	//Also a main method but a little bit more complicated (It starts in an other thread)
		/* Eclipse chooses to run the file that is open here if it has a main class but it only runs one of them
		So if you press play here only this Main method will run not the one in TestCat or the one in TestCatGarden*/ 
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {	
						CatGardenGUI frame = new CatGardenGUI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

}
