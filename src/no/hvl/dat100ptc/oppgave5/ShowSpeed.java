package no.hvl.dat100ptc.oppgave5;

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
	private double[] speeds;

	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Speed profile", 3 * MARGIN + 3 * gpscomputer.speeds().length, 20 + MARGIN + BARHEIGHT);

		showSpeedProfile(MARGIN + BARHEIGHT);
	}

	public void showSpeedProfile(int ybase) {
		speeds = gpscomputer.speeds();

		int x = MARGIN;
		int width = 2;
		int height;

		for (int i = 0; i < speeds.length; i++) {
			speeds[i] = speeds[i] * 3.6;
		}	

		for (int i = 0; i < speeds.length; i++) {
			height = (int) this.speeds[i];

			setColor(0, 0, 255);
			if (height > 0 && height <= BARHEIGHT) {
				fillRectangle(x, ybase - height, width, height);
				x += 3;
			}

		}

		double avgSpeed = gpscomputer.averageSpeed() * 3.6;

		setColor(0, 255, 0);
		drawLine(MARGIN, ybase - (int) avgSpeed, x, ybase - (int) avgSpeed);
	}
}
