package se.mah.k3.grupp4;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class TestGUI extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_Clock;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private Gui2 gui2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI frame = new TestGUI();
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
	public TestGUI() {
		
		
		setBackground(Color.GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, (int)width, (int)height);
		this.setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		label = new JLabel("0 min");
		label.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label.setBounds(414, 257, 82, 51);
		contentPane.add(label);

		label_1 = new JLabel("0 min");
		label_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_1.setBounds(541, 256, 82, 51);
		contentPane.add(label_1);

		label_2 = new JLabel("0 min");
		label_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_2.setBounds(523, 335, 100, 51);
		contentPane.add(label_2);

		label_3 = new JLabel("0 min");
		label_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_3.setBounds(414, 335, 82, 51);
		contentPane.add(label_3);

		label_4 = new JLabel("0 min");
		label_4.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_4.setBounds(523, 421, 100, 51);
		contentPane.add(label_4);

		label_5 = new JLabel("0 min");
		label_5.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_5.setBounds(414, 421, 82, 51);
		contentPane.add(label_5);

		label_6 = new JLabel("0 min");
		label_6.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_6.setBounds(523, 511, 100, 51);
		contentPane.add(label_6);

		label_7 = new JLabel("0 min");
		label_7.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_7.setBounds(414, 511, 82, 51);
		contentPane.add(label_7);

		label_8 = new JLabel("0 min");
		label_8.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_8.setBounds(523, 600, 100, 51);
		contentPane.add(label_8);

		label_9 = new JLabel("0 min");
		label_9.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_9.setBounds(414, 600, 82, 51);
		contentPane.add(label_9);

		label_Clock = new JLabel("12:00");
		label_Clock.setHorizontalAlignment(SwingConstants.CENTER);
		label_Clock.setForeground(Color.WHITE);
		label_Clock.setFont(new Font("Gill Sans MT", Font.PLAIN, 36));
		label_Clock.setBounds(1110, 31, 192, 82);
		contentPane.add(label_Clock);

		label_11 = new JLabel("");
		label_11.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		label_11.setBounds(1044, 256, 100, 51);
		contentPane.add(label_11);

		label_12 = new JLabel("");
		label_12.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		label_12.setBounds(1170, 256, 100, 51);
		contentPane.add(label_12);

		label_13 = new JLabel("");
		label_13.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		label_13.setBounds(1170, 335, 100, 51);
		contentPane.add(label_13);

		label_14 = new JLabel("");
		label_14.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		label_14.setBounds(1043, 335, 100, 51);
		contentPane.add(label_14);

		label_15 = new JLabel("");
		label_15.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		label_15.setBounds(1171, 421, 100, 51);
		contentPane.add(label_15);

		label_16 = new JLabel("");
		label_16.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		label_16.setBounds(1054, 421, 90, 51);
		contentPane.add(label_16);

		label_17 = new JLabel("");
		label_17.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		label_17.setBounds(1170, 511, 100, 51);
		contentPane.add(label_17);

		label_18 = new JLabel("");
		label_18.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		label_18.setBounds(1043, 511, 100, 51);
		contentPane.add(label_18);

		label_19 = new JLabel("");
		label_19.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		label_19.setBounds(1171, 600, 100, 51);
		contentPane.add(label_19);

		label_20 = new JLabel("");
		label_20.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		label_20.setBounds(1044, 600, 100, 51);
		contentPane.add(label_20);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TestGUI.class.getResource("img/mockUpSmall.jpg")));
		lblNewLabel.setBounds(0, 0, (int)width, (int)height);
		contentPane.add(lblNewLabel);
		
		Thread clock= new ClockThread(this);
		clock.start();
		
		Thread t= new testSearchThread(this);
		t.start();
		
	}
	/**
	*Sätter avgångstiden i labelfältet
	*/
		public void setTimeOnLabel(String time, String time2, int line) {

			if (line == 1) {
				label.setText(time);
				label_1.setText(time2);
			}

			else if (line == 2) {
				label_3.setText(time);
				label_2.setText(time2);
			}
			else if (line == 3) {
				label_5.setText(time);
				label_4.setText(time2);
			}

			else if (line == 4) {
				label_7.setText(time);
				label_6.setText(time2);
			}

			else if (line == 5) {
				label_9.setText(time);
				label_8.setText(time2);

			}

			else if (line == 22) {
				label_11.setText(time);
				label_12.setText(time2);
			}

			else if (line == 33) {
				label_14.setText(time);
				label_13.setText(time2);
			}
			else if (line == 33) {
				label_14.setText(time);
				label_13.setText(time2);
			}
			else if (line == 55) {
				label_16.setText(time);
				label_15.setText(time2);
			}
			else if (line == 77) {
				label_18.setText(time);
				label_17.setText(time2);
			}
			else if (line == 88) {
				label_20.setText(time);
				label_19.setText(time2);
			}
	}

		/**
		*Sätter tiden i klockfältet
		*/
		public void setTimeOnLabel(String time){
			label_Clock.setText(time);
					
		}

}
