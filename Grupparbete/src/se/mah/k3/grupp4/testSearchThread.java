package se.mah.k3.grupp4;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import se.mah.k3.grupp4.Journeys;

import se.mah.k3.grupp4.Constants;
import se.mah.k3.grupp4.Parser;

public class testSearchThread extends Thread {
	String searchURL;
	Journeys journeys;
TestGUI testGui;

public testSearchThread(TestGUI test) {
	this.testGui = test;
}

	@Override
	public void run() {
	

		String[] stationsCode= {"80600", "80110", "80840", "80580", "80660"};

		for (int i = 0; i > 5; i++) {

			String thisSearchURL = Constants.getURL("80002", stationsCode[i], 2);
			Journeys journeys = Parser.getJourneys(thisSearchURL);
			//print(journeys);

			
			testGui.setTimeOnLabel(journeys.getJourneys().get(i+1).getRealDepTime() + " min",
					journeys.getJourneys().get(i + 2).getRealDepTime() + " min", i);
			System.out.println(journeys.getJourneys().get(i).getTimeToDeparture());
		

	/** Prints info for debug */
//	public void print(Journeys journeys) {
//
//		try {
//			System.out.print(journeys.getJourneys().get(0).getStartStation().getStationName() + " - ");
//			System.out.print(journeys.getJourneys().get(0).getEndStation().getStationName());
//			System.out.println(" Departs in " + journeys.getJourneys().get(0).realDepTime() + " mothafukkin minutes");
//			System.out.print(journeys.getJourneys().get(1).getStartStation().getStationName() + " - ");
//			System.out.print(journeys.getJourneys().get(1).getEndStation().getStationName());
//			System.out.println(" Departs in " + journeys.getJourneys().get(1).realDepTime() + " mothafukkin minutes");
//			System.out.println("Antal:" + journeys.getJourneys().size()); // debug
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		}
	}
}
/*
 * @Override public void run1() {
 * 
 * // mot c 2an searchURL = Constants.getURL("80002", "80600", 2); journeys =
 * Parser.getJourneys(searchURL);
 * 
 * print(journeys);
 * 
 * Gui2.setTimeOnLabel(journeys.getJourneys().get(0).realDepTime() + " min",
 * journeys.getJourneys().get(1).realDepTime() + " min", 2);
 * 
 * // mot c 3an searchURL = Constants.getURL("80002", "80110", 2); journeys3an =
 * Parser.getJourneys(searchURL); print(journeys3an);
 * 
 * // Send to GUI
 * Gui2.setTimeOnLabel(journeys3an.getJourneys().get(0).realDepTime() + " min",
 * journeys3an.getJourneys().get(1).realDepTime() + " min", 3);
 * 
 * // 5:an mot Malmö C searchURL = Constants.getURL("80002", "80840", 2);
 * Journeys journeys5an = Parser.getJourneys(searchURL);
 * Gui2.setTimeOnLabel(journeys5an.getJourneys().get(0).realDepTime() + " min",
 * journeys5an.getJourneys().get(1).realDepTime() + " min", 5);
 * 
 * // 7:an mot Malmö C searchURL = Constants.getURL("80002", "80580", 2);
 * Journeys journeys7an = Parser.getJourneys(searchURL);
 * Gui2.setTimeOnLabel(journeys7an.getJourneys().get(0).realDepTime() + " min",
 * journeys7an.getJourneys().get(1).realDepTime() + " min", 7);
 * 
 * 
 * //8:an mot Malmö C
 * 
 * searchURL = Constants.getURL("80002", "80660", 2); Journeys journeys8an =
 * Parser.getJourneys(searchURL);
 * Gui2.setTimeOnLabel(journeys8an.getJourneys().get(0).realDepTime() + " min",
 * journeys8an.getJourneys().get(1).realDepTime() + " min", 8);
 * 
 * //2:an från Malmö C
 * 
 * searchURL = Constants.getURL("80002", "80005", 2);
 * 
 * Journeys journeys22an = Parser.getJourneys(searchURL);
 * Gui2.setTimeOnLabel(journeys22an.getJourneys().get(0).realDepTime() + " min",
 * journeys22an.getJourneys().get(1).realDepTime() + " min", 22); //3:an från
 * Malmö C searchURL = Constants.getURL("80002", "80300", 2); Journeys
 * journeys33an = Parser.getJourneys(searchURL);
 * Gui2.setTimeOnLabel(journeys33an.getJourneys().get(0).realDepTime() + " min",
 * journeys33an.getJourneys().get(1).realDepTime() + " min", 33);
 * 
 * //3:an från Malmö C String searchURL = Constants.getURL("80002", "80004", 2);
 * Journeys journeys55an = Parser.getJourneys(searchURL);
 * Gui2.setTimeOnLabel(journeys55an.getJourneys().get(0).realDepTime() + " min",
 * journeys55an.getJourneys().get(1).realDepTime() + " min", 55);
 * 
 * searchURL = Constants.getURL("80002", "80338", 2); Journeys journeys77an =
 * Parser.getJourneys(searchURL);
 * Gui2.setTimeOnLabel(journeys77an.getJourneys().get(0).realDepTime() + " min",
 * journeys77an.getJourneys().get(1).realDepTime() + " min", 77);
 * 
 * searchURL = Constants.getURL("80002", "80040", 2); Journeys journeys88an =
 * Parser.getJourneys(searchURL);
 * Gui2.setTimeOnLabel(journeys88an.getJourneys().get(0).realDepTime() + " min",
 * journeys88an.getJourneys().get(1).realDepTime() + " min", 88); }
 */
