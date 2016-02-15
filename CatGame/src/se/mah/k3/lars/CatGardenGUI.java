package se.mah.k3.lars;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3.lars.model.BarbedWire;
import se.mah.k3.lars.model.Cat;
import se.mah.k3.lars.model.CatFarm;
import se.mah.k3.lars.model.Electric;
import se.mah.k3.lars.model.Hay;
import se.mah.k3.lars.model.Tower;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLayeredPane;

public class CatGardenGUI extends JFrame implements ActionListener{

	
	private JPanel contentPane;	
	//I declared the garden as a variable here because I will probably use it allover the place
	//private Cats garden;
	private GardenController gardenController;
	private JTextArea textArea;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_1;
	private JLayeredPane gameArea;
	/**
	 * Create the frame. 
	 *THIS is the Constructor for the JFrame
	 *
	 */
	public CatGardenGUI() {		
		//The code below is created from GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		gameArea = new JLayeredPane();
		contentPane.add(gameArea, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 640, 480);
		gameArea.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(CatGardenGUI.class.getResource("/images/lawn640x480.jpg")));
		
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{624, 0};
		gbl_panel.rowHeights = new int[]{2, 76, 35, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setRows(4);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		//Load the textarea with the cats
		//This was created by dragging in a button and doubleklick it
		JButton btnKillACat = new JButton("Kill a cat");
		panel_1.add(btnKillACat);
		//Listen for buttonklicks
		//MyListener myListener = new MyListener();
		btnKillACat.addActionListener(this);
		
		
		//Create GardenController
		gardenController = new GardenController(this);
	}

	public JLayeredPane getGameArea(){
		return this.gameArea;
	}
	
	public JTextArea getOutputTextArea(){
		return textArea;
	}
	
	/*private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//This method is called when the Killcat button is pressed
			//So kill it
			gardenController.getCatFarm().killCat();
			//Set new text in the textArea
			textArea.setText(gardenController.getCatFarm().getCats());
		}
	}
*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//So kill it
		gardenController.getCatFarm().killCat();
		//Set new text in the textArea
		textArea.setText(gardenController.getCatFarm().getCats());
	}
}
