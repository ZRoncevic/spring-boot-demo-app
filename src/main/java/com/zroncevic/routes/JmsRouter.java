package com.zroncevic.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zroncevic.model.Flight;
import com.zroncevic.service.FlightProcessor;

@Component
public class JmsRouter extends RouteBuilder{
	
    public static final String AMQ_2EBROKER = "activemq:queue:";
    
    @Value("${jms.router.enabled}")
    public boolean MQ_CONSUMER_ENABLED;
    
    @Value("${jms.router.queue.name}")
    public String MQ_CONSUMER_INCOMING_QUEUE;
	
    
    @Override
	public void configure() throws Exception {
    	
    	if (MQ_CONSUMER_ENABLED) {
    		
			from(AMQ_2EBROKER + MQ_CONSUMER_INCOMING_QUEUE)
					.unmarshal().json(JsonLibrary.Jackson, Flight.class)
					.bean(FlightProcessor.class, FlightProcessor.PROCESSING_INCOMING_MESSAGE_METHOD);

    	
    	} else {
    		System.out.println("JMS Router not enabled for incoming queue");
    		System.out.println("Enabled " + MQ_CONSUMER_ENABLED);
    		System.out.println("Queue name " + MQ_CONSUMER_INCOMING_QUEUE);
    	}
		
	}
    
}
