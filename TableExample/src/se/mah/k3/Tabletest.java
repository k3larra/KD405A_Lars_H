package se.mah.k3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Tabletest extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Item> myItems;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabletest frame = new Tabletest();
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
	public Tabletest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Skapa lite testdata
		myItems = new ArrayList<Item>();
		myItems.add(new Item("Bygga med klossar samt med Lego samt en massa annat skoj som vi kan hitta p� med en l�ng text, h�r �r tre rader samt marginal 10", "Awa Tsar"));
		myItems.add(new Item("Bygga med Lego, det �r lite sv�rt att ha olika radh�jd men n�r ni f�tt allt annat att fungera kan jag hj�lpa er med det.", "Merk Eriksson"));
		myItems.add(new Item("Bygga med Mecano, Ni b�r kunna jobba med JTextareorna som denna �r s� att de har ett typsnitt samt allt annat utseende som ni gillar.", "Eva-Lena H�kansson"));
		myItems.add(new Item("Bygga med rester, s� kolla igenom detta och fr�ga om ni inte f�rst�r, jag tror inte att det fungerar att arbeta med GUI builder h�r i vilket fall s� det g�ller att experimentera samt googla. Lyckat till /L", "Mona Sten Eriksson"));
		myItems.add(new Item("Bygga med klossar samt med Lego samt en massa annat skoj som vi kan hitta p� med en l�ng text, h�r �r tre rader samt marginal 10", "Awa Tsar"));
		myItems.add(new Item("Bygga med Lego, det �r lite sv�rt att ha olika radh�jd men n�r ni f�tt allt annat att fungera kan jag hj�lpa er med det.", "Merk Eriksson"));
		myItems.add(new Item("Bygga med Mecano, Ni b�r kunna jobba med JTextareorna som denna �r s� att de har ett typsnitt samt allt annat utseende som ni gillar.", "Eva-Lena H�kansson"));
		myItems.add(new Item("Bygga med rester, s� kolla igenom detta och fr�ga om ni inte f�rst�r, jag tror inte att det fungerar att arbeta med GUI builder h�r i vilket fall s� det g�ller att experimentera samt googla. Lyckat till /L", "Mona Sten Eriksson"));
		
		//Vill man ha med rubrikerna har man tabellen i en JScrollPane
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1066, 584);
		contentPane.add(scrollPane_1);
		//Skapa tabellen
		table = new JTable();
		//Sen kan ni fixa h�r med hur ni vill att tabeleln skall se ut f�rger o linjer mellan.....
		//L�gg till den i scrollrutan
		scrollPane_1.setViewportView(table);
		//Det finns massa model som hanterar olika saker detta �r nog den vanligaste.
		DefaultTableModel tableModel = new DefaultTableModel(myItems.size(), 2); //Det antal rader som finns i ArrayListan 2 kolumner
		table.setModel(tableModel);
		//S�tt rubriknamn
		table.getColumnModel().getColumn(0).setHeaderValue("Moment");
		table.getColumnModel().getColumn(1).setHeaderValue("L�rare");
		//Koppla en renderare till varje rad se nedan denna ritar alla rader o �r en egen inre klass
		table.getColumnModel().getColumn(0).setCellRenderer(new MomentRenderer());
		table.getColumnModel().getColumn(1).setCellRenderer(new TeacherRenderer());
		//Det �r lite klurigt att s�tta olika radh�jd men n�r allt annat funkar kan jag hj�lpa er
		table.setRowHeight(4*table.getRowHeight());
	}
	
	//De tv� radrenderarna som vi kopplar till vars en kolumn ovan
	private class MomentRenderer extends DefaultTableCellRenderer {
		 
		//Denna metoden anropas en g�ng f�r varje rad som ni ser p� System.out
		 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			 System.out.println("Row: "+row);
			 System.out.println("Column: "+column);
			 //Skapa en JTextArea h�r kan ni fixa med typsnitt etc
			 JTextArea txtArea = new JTextArea();
			 txtArea.setLineWrap(true);
			 txtArea.setMargin(new Insets(10, 10, 10, 10));
			 //H�mta r�tt str�ng fr�n ArrayListan dvs det som finns p� plats row som ju f�r olika v�rde.
			 String moment =  myItems.get(row).getMoment();
			 txtArea.setText(moment); 
			 //Skicka tillbaka arean
			 return txtArea;
		}
	}
	
	private class TeacherRenderer extends DefaultTableCellRenderer {
		 
		 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			 
			 System.out.println("Row: "+row);
			 System.out.println("Column: "+column);
			 JTextArea txtArea = new JTextArea();
			 txtArea.setLineWrap(true);
			 txtArea.setMargin(new Insets(20, 20, 20, 20));
			 txtArea.setText(myItems.get(row).getTeacher()); 
			 return txtArea;
		}
	}
}
