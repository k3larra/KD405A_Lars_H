package se.mah.k3.lars;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3.lars.towers.BarbedWire;
import se.mah.k3.lars.towers.Electric;
import se.mah.k3.lars.towers.Hay;
import se.mah.k3.lars.towers.Tower;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CatGardenGUI extends JFrame {

	
	private JPanel contentPane;	
	//I declared the garden as a variable here because I will probably use it allover the place
	private CatGarden garden;
	private JTextArea textArea;
	private JPanel gameArea;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame. 
	 *THIS is the Constructor for the JFrame
	 *
	 */
	public CatGardenGUI() {
		//Create instance of CarGarden
		garden = new CatGarden("Mor Anna 8");
		//Add the cats about the same as the one in TestCatGarden
		for (int i = 0; i < 50; i++) {
			//Create a Cat
			Cat d = new Cat("green","Olle"+i);
			//Get a random age by an instance of the Random Class
			Random r = new Random();
			//And ask it to deliver a int from 0-300
			int age = r.nextInt(300);
			d.setAge(age);
			garden.addCat(d);
		}
		
		//The code below is created from GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCatkill = new JLabel("CatKill");
		panel.add(lblCatkill);
		
		gameArea = new JPanel();
		contentPane.add(gameArea, BorderLayout.CENTER);
		gameArea.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 259, 487, 50);
		gameArea.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		//Load the textarea with the cats
		textArea.setText(garden.getCats());
		
		//This was created by dragging in a button and doubleklick it
		JButton btnKillACat = new JButton("Kill a cat");
		//Listen for buttonklicks
		btnKillACat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//This method is called when the Killcat button is pressed
				//So kill it
				garden.killCat();
				//Set new text in the textArea
				textArea.setText(garden.getCats());
			
			}
		});
		contentPane.add(btnKillACat, BorderLayout.SOUTH);
		
		//The towers
		BarbedWire bw = new BarbedWire(gameArea); 
		bw.setPosition(100, 50);
		bw.setVisible(true);
		bw.makeSound();
		
		Electric electric = new Electric(gameArea);
		electric.setPosition(50, 100);
		electric.setVisible(true);
		electric.makeSound();
		
		Hay hay = new Hay(gameArea);
		hay.setPosition(100, 100);
		hay.setVisible(true);
		hay.makeSound();
		
		//And declared as a Tower
		Tower t = new Hay(gameArea);
		t.setPosition(10, 10);
		t.setVisible(true);
		t.makeSound();
		
		//Lets make a Arraylist for towers o play some sounds 
		ArrayList<Tower> myTowers = new ArrayList<Tower>();
		myTowers.add(bw);
		myTowers.add(hay);
		myTowers.add(electric);
		myTowers.add(t);
		
		//Make some repeated sound for fun :)......
		//Uhh a anonymous inner class this is not so very easy to understand, just look here
		new Thread(new Runnable() {
			boolean visible = false;
			Random r = new Random();
			@Override
			public void run() {
				while(true){
					//Wait 5 sec
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {}
					//Hide them all
					for (Tower tower : myTowers) {
						tower.setVisible(false);
					}
					//Select a random tower
					int rand = r.nextInt(myTowers.size());
					Tower t = myTowers.get(rand);
					//Set it visible
					t.setVisible(true);
					t.makeSound();
				}
				
			}
		}).start();
	}
}
