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
		myItems.add(new Item("Bygga med klossar samt med Lego samt en massa annat skoj som vi kan hitta på med en lång text, här är tre rader samt marginal 10", "Awa Tsar"));
		myItems.add(new Item("Bygga med Lego, det är lite svårt att ha olika radhöjd men när ni fått allt annat att fungera kan jag hjälpa er med det.", "Merk Eriksson"));
		myItems.add(new Item("Bygga med Mecano, Ni bör kunna jobba med JTextareorna som denna är så att de har ett typsnitt samt allt annat utseende som ni gillar.", "Eva-Lena Håkansson"));
		myItems.add(new Item("Bygga med rester, så kolla igenom detta och fråga om ni inte förstår, jag tror inte att det fungerar att arbeta med GUI builder här i vilket fall så det gäller att experimentera samt googla. Lyckat till /L", "Mona Sten Eriksson"));
		myItems.add(new Item("Bygga med klossar samt med Lego samt en massa annat skoj som vi kan hitta på med en lång text, här är tre rader samt marginal 10", "Awa Tsar"));
		myItems.add(new Item("Bygga med Lego, det är lite svårt att ha olika radhöjd men när ni fått allt annat att fungera kan jag hjälpa er med det.", "Merk Eriksson"));
		myItems.add(new Item("Bygga med Mecano, Ni bör kunna jobba med JTextareorna som denna är så att de har ett typsnitt samt allt annat utseende som ni gillar.", "Eva-Lena Håkansson"));
		myItems.add(new Item("Bygga med rester, så kolla igenom detta och fråga om ni inte förstår, jag tror inte att det fungerar att arbeta med GUI builder här i vilket fall så det gäller att experimentera samt googla. Lyckat till /L", "Mona Sten Eriksson"));
		
		//Vill man ha med rubrikerna har man tabellen i en JScrollPane
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1066, 584);
		contentPane.add(scrollPane_1);
		//Skapa tabellen
		table = new JTable();
		//Sen kan ni fixa här med hur ni vill att tabeleln skall se ut färger o linjer mellan.....
		//Lägg till den i scrollrutan
		scrollPane_1.setViewportView(table);
		//Det finns massa model som hanterar olika saker detta är nog den vanligaste.
		DefaultTableModel tableModel = new DefaultTableModel(myItems.size(), 2); //Det antal rader som finns i ArrayListan 2 kolumner
		table.setModel(tableModel);
		//Sätt rubriknamn
		table.getColumnModel().getColumn(0).setHeaderValue("Moment");
		table.getColumnModel().getColumn(1).setHeaderValue("Lärare");
		//Koppla en renderare till varje rad se nedan denna ritar alla rader o är en egen inre klass
		table.getColumnModel().getColumn(0).setCellRenderer(new MomentRenderer());
		table.getColumnModel().getColumn(1).setCellRenderer(new TeacherRenderer());
		//Det är lite klurigt att sätta olika radhöjd men när allt annat funkar kan jag hjälpa er
		table.setRowHeight(4*table.getRowHeight());
	}
	
	//De två radrenderarna som vi kopplar till vars en kolumn ovan
	private class MomentRenderer extends DefaultTableCellRenderer {
		 
		//Denna metoden anropas en gång för varje rad som ni ser på System.out
		 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			 System.out.println("Row: "+row);
			 System.out.println("Column: "+column);
			 //Skapa en JTextArea här kan ni fixa med typsnitt etc
			 JTextArea txtArea = new JTextArea();
			 txtArea.setLineWrap(true);
			 txtArea.setMargin(new Insets(10, 10, 10, 10));
			 //Hämta rätt sträng från ArrayListan dvs det som finns på plats row som ju får olika värde.
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
