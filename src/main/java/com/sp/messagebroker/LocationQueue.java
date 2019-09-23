package com.sp.messagebroker;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.stereotype.Repository;

@Repository
public class LocationQueue {

	Map<String,Queue<Location>> lQueue;
	
	public LocationQueue() {
		lQueue=new HashMap<String, Queue<Location>>();
	}

	public void addToQueue(Map<String, String> msg) {
		
		String vehicleName= msg.get("vehicle");
		Queue<Location> q= lQueue.get(vehicleName);
		if(q==null) {
			q= new PriorityQueue<Location>();
			lQueue.put(vehicleName, q);
		}
		Location newLocation= new Location(msg.get("lat"),msg.get("long"), msg.get("time"));
		q.add(newLocation);
	}
	
	public Location getLocation(String vehicleName) throws Exception 
	{
		Queue<Location> q = lQueue.get(vehicleName);
		if (q == null) throw new Exception("queue is empty");
		return q.peek();
	}

}
