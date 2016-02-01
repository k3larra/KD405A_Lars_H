package se.mah.k3.lars;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CatGardenGUI extends JFrame {

	
	private JPanel contentPane;	
	//I declared the garden as a variable here because I will probably use it allover the place
	private CatGarden garden;
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
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 13, 351, 184);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
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
		
	}
}
