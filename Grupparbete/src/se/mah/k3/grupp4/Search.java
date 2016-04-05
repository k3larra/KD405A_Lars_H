package se.mah.k3.grupp4;

import java.util.Calendar;
import se.mah.k3.grupp4.Lines;
import se.mah.k3.grupp4.Constants;


public class Search extends Thread{
		@Override
		public void run() {
			//Sökning från en viss station, alla avgångar
			Lines lines = Parser.getStationResults(new Station("80002"));
			for (Line l : lines.getLines()) {
				System.out.println("Line " + l.getLine() +" departs: "+l.getDepTime().get(Calendar.HOUR_OF_DAY)+":"+l.getDepTime().get(Calendar.MINUTE)+
						" and is "+l.getDepTimeDeviation()+" minutes late");
				
			//Sökning mellan stationsnummer
			int noOfRes = 5; //antal resultat
			String searchURL = Constants.getURL("80000", "80210", noOfRes);
			Journeys journeys = Parser.getJourneys(searchURL);

			{
				for (Journey journey : journeys.getJourneys()) {
					String depTime = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY) + ":"
							+ journey.getDepDateTime().get(Calendar.MINUTE);
					String arrTime = journey.getArrDateTime().get(Calendar.HOUR_OF_DAY) + ":"
							+ journey.getArrDateTime().get(Calendar.MINUTE);
					//textAreaJourneys.setText(journey.getInfo(depTime, arrTime));

				}
			}
		}


}
}
