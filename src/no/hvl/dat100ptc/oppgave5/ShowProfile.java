package no.hvl.dat100ptc.oppgave5;

import no.hvl.dat100ptc.TODO;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;
import static java.lang.Math.*;

import java.awt.Color;

import javax.swing.JOptionPane;

public class ShowProfile extends EasyGraphics {

	private static final int MARGIN = 50;		// margin on the sides 
	
	private static final int MAXBARHEIGHT = 500; // assume no height above 500 meters
	
	private GPSPoint[] gpspoints;

	public ShowProfile() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn (uten .csv): ");
		GPSComputer gpscomputer =  new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length; // number of data points

		makeWindow("Height profile", 2 * MARGIN + 3 * N, 2 * MARGIN + MAXBARHEIGHT);

		// top margin + height of drawing area
		showHeightProfile(MARGIN + MAXBARHEIGHT); 
	}

	public void showHeightProfile(int ybase) {
		
		int x = MARGIN; // første høyde skal tegnes ved MARGIN
		int y = ybase;
		int N = gpspoints.length;
		int width = 2 * MARGIN + 3 * N;
		int step = width/N;
		setColor(0,0,255);
		for (int i = 0; i<gpspoints.length-1; i++) {
				int y_base = y;
				int x_base = x+(i*step);
				int y_top = y-(int)round(gpspoints[i].getElevation());
				int x_top = x+(i*step);
				drawLine(x_base, y_base, x_top, y_top);
				}
		
		// TODO 
		//throw new UnsupportedOperationException(TODO.method());
		

	}

}
