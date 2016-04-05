package se.mah.k3.grupp4;

import java.util.Calendar;
import se.mah.k3.grupp4.Constants;

public class TestClass {

	public static void main(String[] args) {
		String searchURL = Constants.getURL("80000","81216",2);
		//Denna metod hämtar söksträngen för resa från Malmö till Lund, med 20 resultat //Malmö C = 80000,  Lund C, 81216 Malmö Gatorg 80100, Hässleholm C 93070

		System.out.println(searchURL);
		System.out.println("// Results when searching:");
		
		Journeys journeys = Parser.getJourneys(searchURL); 
		for (Journey journey : journeys.getJourneys()) {
//			System.out.println(journey.getStartStation().getInfo()+" \n ");
//			System.out.println(journey.getEndStation().getInfo()+" \n ");

			System.out.print(journey.getStartStation().getStationName()+" - ");
			System.out.print(journey.getEndStation().getStationName());
//			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
//			System.out.println(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late");
		} 
		
//	   System.out.println("// Stations when searching for stations containing \"Malm\"");
//		ArrayList<Station> searchStations = new ArrayList<Station>(); //skapar en ny ArrayList för Stationer som börjar med "Malm"
//		searchStations.addAll(Parser.getStationsFromURL("Malm")); //lägger till alla sökresultat i den ArrayList som just skapats
//		for (Station s: searchStations){
//			System.out.println(s.getStationName() +" number:" +s.getStationNbr());
//		}
		
//		System.out.println("// Busses departing from Ubåtshallen stationsnummer 80046 ");
//		Lines lines = Parser.getStationResults(new Station("80002"));
//		for (Line l : lines.getLines()) {
//			System.out.println("Line " + l.getLine() +" departs: "+l.getDepTime().get(Calendar.HOUR_OF_DAY)+":"+l.getDepTime().get(Calendar.MINUTE)+
//					" and is "+l.getDepTimeDeviation()+" minutes late");
//		}
	}
}

