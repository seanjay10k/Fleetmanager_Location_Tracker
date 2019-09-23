package com.sp.messagebroker;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MessagebrokerApplication {

	public static void main(String[] args) throws JMSException {
		//get hold of spring application context
		ApplicationContext ctx= SpringApplication.run(MessagebrokerApplication.class, args);
//		//get the jmstemplate bean from spring context
//		JmsTemplate jmsTemplate= ctx.getBean(JmsTemplate.class);
//		//no guarenteed order of message, but gets one at a time
//		String m= jmsTemplate.receiveAndConvert("positionQueue").toString();
//		Message m= jmsTemplate.receive("positionQueue");
//		TextMessage t=(TextMessage) m;
//		String s= t.getText();
//		System.out.println(m);
		
		
	}

}
