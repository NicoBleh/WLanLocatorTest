package com.locator.wlan.test;

import android.test.AndroidTestCase;

import com.locator.wlan.WLanAccessPoint;

public class WLanAccessPointTest extends AndroidTestCase{

	WLanAccessPoint wLanPoint =  new WLanAccessPoint("1234", "12345");
	
	public void setUp() throws Exception {
		wLanPoint.setSignalDistance(-20, 1);
		wLanPoint.setSignalDistance(-30, 2);
		wLanPoint.setSignalDistance(-40, 3);
		wLanPoint.setSignalDistance(-50, 4);
		wLanPoint.setSignalDistance(-60, 5);
	}

	public void testGetDistanceFromSignalstrength() {
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-10.0) < 1);
		assertEquals(1.0, wLanPoint.getDistanceFromSignalstrength(-20.0), 0);
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-25.0) > 1);
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-25.0) < 2);
		assertEquals(2.0, wLanPoint.getDistanceFromSignalstrength(-30.0), 0);
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-70.0) > 5);
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-100.0) > 5);
		
		wLanPoint.setSignalDistance(-70, 6);
		
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-10.0) < 1);
		assertEquals(1.0, wLanPoint.getDistanceFromSignalstrength(-20.0), 0);
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-25.0) > 1);
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-25.0) < 2);
		assertEquals(2.0, wLanPoint.getDistanceFromSignalstrength(-30.0), 0);
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-70.0) > 5);
		assertTrue(wLanPoint.getDistanceFromSignalstrength(-100.0) > 5);
		
	}

}
