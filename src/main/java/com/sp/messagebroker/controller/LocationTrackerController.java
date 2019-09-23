package com.sp.messagebroker.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.messagebroker.Location;
import com.sp.messagebroker.LocationQueue;


@RestController
public class LocationTrackerController {
	@Autowired
	private LocationQueue locQ;
	
	@RequestMapping(method=RequestMethod.GET,value="/vehicles/{vehicleName}")
	public ResponseEntity<Loc> getVehicleLatest(@PathVariable String vehicleName)
	{
		try 
		{
			Location l = locQ.getLocation(vehicleName);
			Loc loc= new Loc();
			loc.lat=l.getLat();
			loc.longitude=l.getLon();
			loc.timestamp=l.getDateStamp();
			return new ResponseEntity<Loc>(loc, HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	static class Loc{
		private String lat;
		private String longitude;
		private Date timestamp;
		
		public String toString() {
			return this.lat+" , "+this.longitude+" , "+this.timestamp;
		}
		public String getLat() {
			return lat;
		}
		public void setLat(String lat) {
			this.lat = lat;
		}
		public String getLongitude() {
			return longitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
	}
	
	
	
	
	
}
