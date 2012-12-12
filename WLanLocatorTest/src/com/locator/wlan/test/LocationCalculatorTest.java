package com.locator.wlan.test;

import java.text.DecimalFormat;
import java.util.HashMap;
import android.test.AndroidTestCase;

import com.locator.wlan.Location;
import com.locator.wlan.WLanAccessPoint;
import com.locator.wlan.WLanManager;
import com.locator.wlan.WLanResult;
import com.locator.wlan.calculator.LocationCalculator;

public class LocationCalculatorTest  extends AndroidTestCase {

	double[][] matrix, tmatrix, invmatrix;
	LocationCalculator locCal;
	WLanManager wLanManager;
	HashMap<String, WLanResult> knownscanmap;
	HashMap<String, WLanResult> notknownscanmap;
	DecimalFormat df = new DecimalFormat("#0.00");
	
	public void setUp() throws Exception {
		
		wLanManager = new WLanManager();
		
		WLanAccessPoint ap1 = new WLanAccessPoint("1", "1");
		ap1.setLocation(new Location(0.0, 0.0, 0.0));
		ap1.setSignalDistance(-30, 2);
		ap1.setSignalDistance(-40, 3.24);
		ap1.setSignalDistance(-50, 4.24);
		ap1.setSignalDistance(-60, 5.24);
		wLanManager.addWLanAccesspoint(ap1);
		
		WLanAccessPoint ap2 = new WLanAccessPoint("2", "2");
		ap2.setLocation(new Location(2, 1, 0));
		ap2.setSignalDistance(-30, 1);
		ap2.setSignalDistance(-40, 2);
		ap2.setSignalDistance(-50, 3);
		ap2.setSignalDistance(-60, 4);
		wLanManager.addWLanAccesspoint(ap2);
		
		WLanAccessPoint ap3 = new WLanAccessPoint("3", "3");
		ap3.setLocation(new Location(3, 0, 0));
		ap3.setSignalDistance(-30, 1);
		ap3.setSignalDistance(-40, 4.41);
		ap3.setSignalDistance(-50, 5.41);
		ap3.setSignalDistance(-60, 6.41);
		wLanManager.addWLanAccesspoint(ap3);
		
		WLanAccessPoint ap4 = new WLanAccessPoint("4", "4");
		ap4.setLocation(new Location(2, 0, 1));
		ap4.setSignalDistance(-30, 1);
		ap4.setSignalDistance(-40, 2);
		ap4.setSignalDistance(-50, 3);
		ap4.setSignalDistance(-60, 4);
		wLanManager.addWLanAccesspoint(ap4);
		
		locCal = new LocationCalculator(wLanManager);
		knownscanmap = new HashMap<String, WLanResult>();
		
		knownscanmap.put("1", new WLanResult("1", "1", -30));
		knownscanmap.put("2", new WLanResult("2", "2", -30));
		knownscanmap.put("3", new WLanResult("3", "3", -30));
		knownscanmap.put("4", new WLanResult("4", "4", -30));
		
		
		notknownscanmap = new HashMap<String, WLanResult>();
		notknownscanmap.put("5", new WLanResult("5", "5", -40));
		notknownscanmap.put("6", new WLanResult("6", "6", -40));
		notknownscanmap.put("7", new WLanResult("7", "7", -40));
		notknownscanmap.put("8", new WLanResult("8", "8", -40));
	}

	public void testGetLocation() {
		Location location;
		
		//Test null
		location = locCal.getLocation(null);
		assertEquals(null, location);
		
		//Test Calculation with known Accesspoints
		location = locCal.getLocation(knownscanmap);
		double[] test = {2.0, 0.0, 0.0};
		double[] res = {location.getLatitude(), location.getLongitude(), location.getHeight()};
		assertEquals(test[0], res[0], 0.1);
		assertEquals(test[1], res[1], 0.1);
		assertEquals(test[2], res[2], 0.1);
		
		//Test Calculation no known Accesspoints
		location = locCal.getLocation(notknownscanmap);
		assertEquals(null, location);
	}	
}
