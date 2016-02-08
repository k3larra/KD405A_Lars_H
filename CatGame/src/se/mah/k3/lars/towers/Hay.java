package se.mah.k3.lars.towers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import se.mah.k3.lars.CatGardenGUI;

public class Hay extends Tower {

	public Hay(JPanel gameArea) {
		super(gameArea);
		label.setIcon(new ImageIcon(CatGardenGUI.class.getResource("/images/hay.png")));
	}

	@Override
	public void makeSound() {
		  {
			  try {
		         URL url = CatGardenGUI.class.getResource("/sound/hay.wav");
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
