package com.sp.messagebroker;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MessageDrivenReceiverMDP {
	
	@Autowired
	private LocationQueue lQueue;

	@JmsListener(destination="locationQueue")
	public void processReceivedMessage(Map<String,String> msg) {// we know it is text message in our case
		//automatically message is converted to string
//		System.out.println(System.currentTimeMillis());
//		if(1==1) throw new RuntimeException("lolol");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lQueue.addToQueue(msg);
		System.out.println("im receiver"+msg);
	}
}

