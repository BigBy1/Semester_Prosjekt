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

		for (int i = 0; i < gpspoints.length - 1; i++) {
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);
		}
		return distance;

	}

	public double totalElevation() {

		double elevation = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			if (gpspoints[i].getElevation() < gpspoints[i + 1].getElevation()) {
				elevation += gpspoints[i + 1].getElevation() - gpspoints[i].getElevation();
			}
		}
		return elevation;

	}

	public int totalTime() {

		return gpspoints[gpspoints.length - 1].getTime() - gpspoints[0].getTime();
	}

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length - 1];

		for (int i = 0; i < gpspoints.length - 1; i++) {

			double timediff = gpspoints[i + 1].getTime() - gpspoints[i].getTime();

			double distance = GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);

			speeds[i] = (distance / timediff);

		}
		return speeds;
	}

	public double maxSpeed() {

		double maxspeed = 0;

		double[] speeds = speeds();

		for (int i = 0; i < gpspoints.length - 1; i++) {
			if (maxspeed < speeds[i]) {
				maxspeed = speeds[i];
			}
		}
		return maxspeed;
	}

	public double averageSpeed() {

		double average = totalDistance() / totalTime();

		return average;
	}

	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;
		double speedmph = speed * MS;
		double hour = secs / 3600.0;

		if (speedmph < 10) {
			met = 4;
		} else if (speedmph < 12) {
			met = 6;
		} else if (speedmph < 14) {
			met = 8;
		} else if (speedmph < 16) {
			met = 10;
		} else if (speedmph < 20) {
			met = 12;
		} else {
			met = 16;
		}

		kcal = met * weight * hour;
		return kcal;
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		double[] speed = speeds();
		int timediff = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {

			timediff = (gpspoints[i + 1].getTime() - gpspoints[i].getTime());
			totalkcal += kcal(weight, timediff, speed[i]);

		}
		return totalkcal;
	}

	private static double WEIGHT = 80.0;

	public void displayStatistics() {

		int hours = totalTime() / 3600;
		int minutes = (totalTime() % 3600) / 60;
		int seconds = totalTime() % 60;

		StringBuilder stat = new StringBuilder();

		stat.append("==============================================\n");
		stat.append(String.format("Total Time     :   %02d:%02d:%02d\n", hours, minutes, seconds));
		stat.append(String.format("Total distance :      %8.2f km\n", totalDistance() / 1000.0));
		stat.append(String.format("Total elevation:     %8.2f m\n", totalElevation()));
		stat.append(String.format("Max speed      :      %8.2f km\n", maxSpeed() * 3.6));
		stat.append(String.format("Average speed  :      %8.2f km\n", averageSpeed() * 3.6));
		stat.append(String.format("Energy         :     %8.2f kcal\n", totalKcal(WEIGHT)));
		stat.append("==============================================\n");

		System.out.println(stat.toString());
	}

}
