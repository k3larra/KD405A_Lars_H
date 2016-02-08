package se.mah.k3.lars.towers;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import se.mah.k3.lars.CatGardenGUI;

public class Electric extends Tower {

	
	public Electric(JPanel panel) {
		super(panel);
		label.setIcon(new ImageIcon(CatGardenGUI.class.getResource("/images/electric.jpg")));
		//getLabel().setIcon(new ImageIcon(CatGardenGUI.class.getResource("/images/electric.jpg")));
		setVisible(false);
	}

	@Override
	public void makeSound() {
		{
			  try {
		         URL url = CatGardenGUI.class.getResource("/sound/electric.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		         Clip clip;
				 clip = AudioSystem.getClip();
		         clip.open(audioIn);
		         clip.start();
			  }
		      catch (Exception e) {
						e.printStackTrace();
			  }
	    }
		
	}

}
