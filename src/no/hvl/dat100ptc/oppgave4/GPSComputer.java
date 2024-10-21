package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double distance = 0;

		for (int i = 0; i<gpspoints.length-1; i++) {
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
		}
		return distance;
	}

	public double totalElevation() {

		double elevation = 0;

		for (int i = 0; i<gpspoints.length-1; i++) {
			if (gpspoints[i+1].getElevation() > gpspoints[i].getElevation()){
			elevation += gpspoints[i+1].getElevation() - gpspoints[i].getElevation();
			}
		}
		return elevation;
	}

	public int totalTime() {
		
		int time = 0;

		for (int i = 0; i<gpspoints.length-1; i++) {
			time += gpspoints[i+1].getTime() - gpspoints[i].getTime();
		}
		return time;
		
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		
		for (int i = 0; i<gpspoints.length-1; i++) {
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}
		return speeds;
		
	}
	
	public double maxSpeed() {
		
		double maxspeed = GPSUtils.findMax(speeds());
		return maxspeed;
	
	}

	public double averageSpeed() {

		double avgSpeed = totalDistance() / totalTime();
		return avgSpeed;
		
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double met = 0;
		
		double speedmph = speed * MS;
		
		if (speedmph < 10) {
			met = 4;
		} else if (speedmph < 12){
			met = 6;
		} else if (speedmph < 14){
			met = 8;
		} else if (speedmph < 16){
			met = 10;
		} else if (speedmph < 20){
			met = 12;
		} else {
			met = 16;
		}

		double kcal = met * weight * secs;
		return kcal;
	}

	public double totalKcal(double weight) {

		double totalkcal = kcal(weight, totalTime(), averageSpeed());
		return totalkcal;

		
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

}
