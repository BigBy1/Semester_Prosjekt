package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		//henter ut timer fra stringen
		char hrC1 = timestr.charAt(11);
		char hrC2 = timestr.charAt(12);
		
		//henter ut minutter fra stringen
		char minC1 = timestr.charAt(14);
		char minC2 = timestr.charAt(15);
		
		//henter ut sekunder fra stringen
		char secC1 = timestr.charAt(17);
		char secC2 = timestr.charAt(18);
		
		//gjør om char til Streng
		
		String hrS1 = String.valueOf(hrC1);
		String hrS2 = String.valueOf(hrC2);
		String hrS = hrS1+hrS2;
		
		String minS1 = String.valueOf(minC1);
		String minS2 = String.valueOf(minC2);
		String minS = minS1+minS2;
		
		String secS1 = String.valueOf(secC1);
		String secS2 = String.valueOf(secC2);
		String secS = secS1+secS2;
		
		//Gjør om Streng til int
		
		hr=Integer.parseInt(hrS);
		min=Integer.parseInt(minS);
		sec=Integer.parseInt(secS);
		
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
