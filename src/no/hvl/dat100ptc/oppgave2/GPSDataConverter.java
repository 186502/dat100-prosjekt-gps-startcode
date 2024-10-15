package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		String hrTxt = timestr.substring(TIME_STARTINDEX, 13);	
		String minTxt = timestr.substring(14, 16);
		String secTxt = timestr.substring(17, 19);
		
		int hr = Integer.parseInt(hrTxt);
		int min = (hr*60) + Integer.parseInt(minTxt);
		int sec = (min*60) + Integer.parseInt(secTxt);
		
		return sec;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
		
		int time = toSeconds(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);

		GPSPoint gpspoint = new GPSPoint (time, latitude, longitude, elevation);
		return gpspoint;
		
	}
	
}
