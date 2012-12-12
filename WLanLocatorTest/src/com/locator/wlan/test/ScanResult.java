package com.locator.wlan.test;

public class ScanResult {
	public String SSID;
	public String BSSID;
	public int level;
	
	public ScanResult(String SSID, String BSSID, int level) {
		this.SSID = SSID;
		this.BSSID = BSSID;
		this.level = level;
	}
}
