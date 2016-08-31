package se.mah.k3.klara;

public class Main {
//https://code.google.com/archive/p/bluecove/downloads
	
	public static void main(String[] args) {

        System.out.println("Start !");
		BT bt = new BT();
		bt.startInquiry(10000);
	}
}
