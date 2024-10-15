package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		String str = timestr.substring(TIME_STARTINDEX);
		
		//henter ut timer
		hr = Integer.parseInt(str.substring(0,2));
		
		//henter ut minutter
		min = Integer.parseInt(str.substring(3,5));
		
		//henter ut sekunder
		sec = Integer.parseInt(str.substring(6,8));
		
		
		// få alt til sekunder
		secs = hr*60*60+min*60+sec;
		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		
		int time = toSeconds(timeStr);
		
		double latitude = Double.parseDouble(latitudeStr);
		
		double longitude = Double.parseDouble(longitudeStr);
		
		double elevation = Double.parseDouble(elevationStr); 
		
		// slå sammen infoen
		
		GPSPoint gpspoint = new GPSPoint(time, latitude, longitude, elevation);
				
			return gpspoint;	
	}
	
}
