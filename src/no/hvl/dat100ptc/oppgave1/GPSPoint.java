package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	private int time;
	private double latitude;
	private double longitude;
	private double elevation;
	
	public GPSPoint(int time, double latitude, double longitude, double elevation) {
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		
	}

	public int getTime() {
		
		return time;
		
	}

	public void setTime(int newTime) {
				
		this.time = newTime;
		
	}

	public double getLatitude() {
		
		return latitude;
		
		
	}

	public void setLatitude(double newLatitude) {
		
		this.latitude = newLatitude;
		
	}

	public double getLongitude() {
		
		return longitude;
		
	}

	public void setLongitude(double newLongitude) {
		
		this.longitude = newLongitude;
		
	}

	public double getElevation() {
		
		return elevation;
		
	}

	public void setElevation(double newElevation) {
		
		this.elevation = newElevation;
		
	}
	
	public String toString() {
		
		String timeTxt = Integer.toString(time);
		String latiTxt = Double.toString(latitude);
		String longiTxt = Double.toString(longitude);
		String elevTxt = Double.toString(elevation);
		
		String str = timeTxt+" ("+latiTxt+","+longiTxt+") "+elevTxt+"\n";
		return str;
		
	}
}
