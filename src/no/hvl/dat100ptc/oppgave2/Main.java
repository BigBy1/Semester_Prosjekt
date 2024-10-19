package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {
		
		int antall = 2;
		
		//gpspoint 1
		int time1 = 4;
		
		double latitud1 = 10.0;
		
		double longitude1=13.0;
		
		double elevation1=14.5;
		
		//gpspoint 2
		int time2 = 6;
		
		double latitud2 = 9.5;
		
		double longitude2=14.5;
		
		double elevation2=3.6;
		
		 GPSPoint gpspoint1 = new GPSPoint(time1,latitud1, longitude1, elevation1);
		 GPSPoint gpspoint2 = new GPSPoint(time2,latitud2, longitude2, elevation2);
		 
		 GPSData gpsdata = new GPSData(antall);
		 
		 gpsdata.insertGPS(gpspoint1);
		 gpsdata.insertGPS(gpspoint2);
		 
		 gpsdata.print();
	}
}
