package com.zroncevic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zroncevic.model.Flight;
import com.zroncevic.repository.FlightDAO;

@Service
public class FlightProcessor {
	
	@Autowired
	private FlightDAO flightDAO;
	
	public static final String PROCESSING_INCOMING_MESSAGE_METHOD= "processIncomingFlight";
	
	public void processIncomingFlight(Flight flight){
		
		System.out.println("Received flight: " + flight.toString());
		
		flightDAO.addNewFlight(flight);
		
	}
}
