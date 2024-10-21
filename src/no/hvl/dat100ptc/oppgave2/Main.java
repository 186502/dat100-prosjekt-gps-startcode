package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;

public class Main {

	
	public static void main(String[] args) {
		GPSPoint P1 = new GPSPoint(1, 2.0, 3.0, 5.0);
		GPSPoint P2 = new GPSPoint(2, 3.0, 4.0, 5.0);
		GPSData D1 = new GPSData(2);
		D1.insertGPS(P1);
		D1.insertGPS(P2);
		D1.print();
	}
}
