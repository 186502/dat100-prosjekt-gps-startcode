package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min; 
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
		
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		
		double[] latitudes = new double[gpspoints.length];
		for (int i = 0; i<gpspoints.length;i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		
		double[] longitudes = new double[gpspoints.length];
		for (int i = 0; i<gpspoints.length;i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double latitude1 = gpspoint1.getLatitude();
		double longitude1 = gpspoint1.getLongitude();
		double latitude2 = gpspoint2.getLatitude();
		double longitude2 = gpspoint2.getLongitude();

		double phi1 = Math.toRadians(latitude1);
		double phi2 = Math.toRadians(latitude2);
		double deltaphi = phi2 - phi1;
		double deltadelta = Math.toRadians(longitude2-longitude1);
		
		double a = compute_a(phi1, phi2, deltaphi, deltadelta);
		double c = compute_c(a);
		double d = R*c;
		
		return d;
		
		
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		double a = Math.pow(Math.sin(deltaphi/2), 2)+Math.cos(phi1)*Math.cos(phi2)*Math.pow(Math.sin(deltadelta/2), 2);
		return a;

	}

	private static double compute_c(double a) {

		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return c;
	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs = gpspoint2.getTime() - gpspoint1.getTime();
		double speed = distance(gpspoint1, gpspoint2) / secs;
		
		return speed;

	}

	public static String formatTime(int secs) {
		
		int hours = secs / 3600;
		int minutes = (secs % 3600) / 60;
		int seconds = secs % 60;

		String timestr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		return timestr;
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		double d1 = (Math.round(d*100));
		double dRound = d1/100;
		
		String dRoundTxt = String.valueOf(dRound);
		String padded = String.format("%10s", dRoundTxt);
		return padded;
		
	}
}
