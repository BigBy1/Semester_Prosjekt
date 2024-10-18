package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {

		gpspoints = new GPSPoint[antall];
		
		
		antall = 0;
		
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		if (this.antall<this.gpspoints.length) {
			this.gpspoints[antall]=gpspoint;
			inserted = true;
		}
		else {
			inserted = false;
		}
		
		this.antall+=1;
		
		return inserted;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;
		boolean inserted = false;
		

		int timeI = GPSDataConverter.toSeconds(time);
		
		double latitudeI = Double.parseDouble(latitude);
		double longitudeI = Double.parseDouble(longitude);
		double elevationI = Double.parseDouble(elevation);
		
		gpspoint = new GPSPoint(timeI,latitudeI,longitudeI, elevationI);
		
		inserted = insertGPS(gpspoint);
		
		
		
		return inserted;
	}

	public void print() {
		

		for (int i = 0;i<gpspoints.length;i=i+1) {
			if (i==0) {
				System.out.println("====== GPS Data - START ======"+"\n"
						+gpspoints[i]);
			}
			else if (i==gpspoints.length-1) {
				System.out.println(gpspoints[i]+"\n"
						+"====== GPS Data - SLUTT ======");
			}
			else {
				System.out.println(gpspoints[i]+"\n");
			}
		}
	}
}
