package no.hvl.dat100ptc.oppgave5;

import static java.lang.Math.round;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;
import no.hvl.dat100ptc.TODO;

public class ShowSpeed extends EasyGraphics {
			
	private static int MARGIN = 50;
	private static int BARHEIGHT = 100; 

	private GPSComputer gpscomputer;
	
	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Speed profile", 
				2 * MARGIN + 
				2 * gpscomputer.speeds().length, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT);
	}
	
	public void showSpeedProfile(int ybase) {
		
		int x = MARGIN;
		int y = ybase;
		int width = 2 * MARGIN + 2 * gpscomputer.speeds().length;
		int step = width/gpscomputer.speeds().length;
		int avg_speed = (int)round(gpscomputer.averageSpeed());
		
		for (int i = 0; i<gpscomputer.speeds().length-1; i++) {
			int y_base = y;
			int x_base = x+(i*step);
			int y_top = y-(int)round(gpscomputer.speeds()[i]);
			int x_top = x+(i*step);
			setColor(0,0,255);
			drawLine(x_base, y_base, x_top, y_top);
			}
		setColor(0,255,0);
		drawLine(x, y-avg_speed, MARGIN + 2 * gpscomputer.speeds().length, y-avg_speed);
		
	}
}
