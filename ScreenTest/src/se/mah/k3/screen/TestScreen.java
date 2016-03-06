package se.mah.k3.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;


import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;

public class TestScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestScreen frame = new TestScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 double width = screenSize.getWidth();
		 double height = screenSize.getHeight();
		 System.out.println("JFrame Width: "+width+" Height: "+height);
		 this.setBounds(0, 0, (int)width, (int)height); 
		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(50, 50, 50, 50);
		contentPane.add(panel_1);
		
		JLabel lblMylabel = new JLabel("InfoScreen");
		lblMylabel.setForeground(Color.WHITE);
		lblMylabel.setBackground(SystemColor.inactiveCaptionBorder);
		lblMylabel.setFont(new Font("Century Gothic", lblMylabel.getFont().getStyle(), 29));
		lblMylabel.setBounds(77, 184, 235, 154);
		contentPane.add(lblMylabel);
	}
}