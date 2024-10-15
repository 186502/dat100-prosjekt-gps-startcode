package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		gpspoints = new GPSPoint[n];
		antall = 0;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {
		
		boolean inserted = false;
		
		if(antall<gpspoints.length) {
			gpspoints[antall] = gpspoint;
			inserted = true;
			antall++;
			return inserted;
		} else {
			return inserted;
		}
		
	}

	public boolean insert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		boolean inserted = false;
		int time = Integer.parseInt(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		GPSPoint gpspoint = new GPSPoint (time, latitude, longitude, elevation);
		
		if(antall<gpspoints.length) {
			gpspoints[antall] = gpspoint;
			inserted = true;
			antall++;
			return inserted;
		} else {
			return inserted;
		}
		
	}

	public void print() {
		
		System.out.println("====== GPS Data - START ======");

		for (int i = 0; i<gpspoints.length;i++) {
			System.out.println(gpspoints[i].toString());
		}
		
		System.out.println("====== GPS Data - SLUTT ======");
	}
}
