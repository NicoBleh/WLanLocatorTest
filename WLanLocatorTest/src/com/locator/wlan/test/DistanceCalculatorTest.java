package com.locator.wlan.test;

import android.test.AndroidTestCase;

import com.locator.wlan.Location;
import com.locator.wlan.calculator.DistanceCalculator;


public class DistanceCalculatorTest extends AndroidTestCase {
	
	private DistanceCalculator distCal;

	Location x = new Location(1, 2, 3);
	Location a = new Location(1, 2, 3);
	Location b = new Location(3, 2, 1);
	
	
	public void setUp() throws Exception {
		distCal = new DistanceCalculator();
	}

	
	public void testCalculateDistance() {
		assertEquals(0, distCal.calculateDistance(x, x), 0);
		assertEquals(2.83, distCal.calculateDistance(a, b), 0.01);
	}

}
