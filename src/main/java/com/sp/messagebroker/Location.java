package com.sp.messagebroker;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Location implements Comparable<Location>{

	private String lat;
	private String lon;
	private Date dateStamp;

	public Location(String string, String string2, String string3) {
		this.lat=string;
		this.lon=string2;
		DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		try {
			this.dateStamp = format.parse(string3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int compareTo(Location l) 
	{
		return l.dateStamp.compareTo(this.dateStamp);

	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public Date getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}
	
	

}