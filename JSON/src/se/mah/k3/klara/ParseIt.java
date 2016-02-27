package se.mah.k3.klara;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

public class ParseIt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParseIt frame = new ParseIt();
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
	public ParseIt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Gson g = new Gson();

		Person person = g.fromJson("{\"name\": \"John\"}", Person.class);
		System.out.println(person.name); //John
		
		Person p2 = new Person();
		p2.setAge(23);
		p2.setName("Karl");
		System.out.println(g.toJson(p2));
	

		System.out.println(g.toJson(person)); // {"name":"John"}
		//Weather
		//CatGardenGUI.class.getResource("/images/lawn640x480.jpg")
	}
	
	private class Person {
	    private String name;
		private int age;
	    
		public Person() {
	    }
		
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		
	    public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}


	}

}
