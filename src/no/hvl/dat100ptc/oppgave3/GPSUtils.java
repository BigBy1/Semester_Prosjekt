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

		double min=da[0];
		
		for (int i = 0; i<da.length;i++) {
			if(min>da[i]) {
				min=da[i];
			}
		}
		return min;
		
		
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double [gpspoints.length];
		
		for (int i=0; i<gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longetudes = new double [gpspoints.length];
		
		for (int i=0; i<gpspoints.length; i++) {
			longetudes[i] = gpspoints[i].getLongitude();
		}
		
		
		return longetudes;
	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		double longitude, latitude;
		
		
		latitude1=Math.toRadians(gpspoint1.getLatitude());
		longitude1=Math.toRadians(gpspoint1.getLongitude());
		
		latitude2=Math.toRadians(gpspoint2.getLatitude());
		longitude2=Math.toRadians(gpspoint2.getLongitude());
		
		longitude = longitude2-longitude1;
		latitude = latitude2-latitude1;
		
		double a =Math.pow(Math.sin(latitude/2), 2)+Math.cos(latitude1)*Math.cos(latitude2)*Math.pow(Math.sin(longitude/2),2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		d = R*c;
		
		return d;
		
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO 

	}

	private static double compute_c(double a) {

		
		throw new UnsupportedOperationException(TODO.method());
		
		
		// TODO 

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		double lengde;
		
		int secs1 = gpspoint1.getTime();
		int secs2 = gpspoint2.getTime();
		secs=secs2-secs1;
		lengde= distance(gpspoint1, gpspoint2);
		
		speed = lengde/secs;
		
		return speed;
	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		String timerstr;
		String minutterstr;
		String secsstr;

		int timer = secs/3600;
		int rest = secs%3600;
		int minutter = rest/60;
		secs = rest%60;
		
		if (timer<10) {
			timerstr=0+""+timer;
		}
		else {
			timerstr=""+timer;
		}
		
		if (minutter<10) {
			minutterstr=0+""+minutter;
		}
		else {
			minutterstr=""+minutter;
		}
		
		if (secs<10) {
			secsstr=0+""+secs;
		}
		else {
			secsstr=""+secs;
		}
		
		
		timestr = "  "+timerstr + ":"+minutterstr+":" + secsstr;
		
		return timestr;
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		d=d+0.005;
		d=100*d;
		
		int int1 = (int) (d);
		
		
		d= int1/100.0;
		
		str="      "+d;
		return str;
		
	}
}
