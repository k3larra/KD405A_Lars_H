package se.mah.k3.grupp4;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.EventQueue;
	import java.awt.Toolkit;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.ImageIcon;

	public class Screen1 extends JFrame {

		private JPanel contentPane;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Screen1 frame = new Screen1();
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
		public Screen1() {
			
			setBackground(Color.GRAY);Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			double height = screenSize.getHeight();


			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(0, 0, (int)width, (int)height);
			this.setUndecorated(true);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("testimg");
			lblNewLabel.setIcon(new ImageIcon(Screen1.class.getResource("img/malm.png")));
			lblNewLabel.setBounds(0, 0, (int)width, (int)height);
			contentPane.add(lblNewLabel);
			
		}
	}

