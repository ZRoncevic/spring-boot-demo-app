package com.zroncevic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zroncevic.model.Flight;
import com.zroncevic.repository.FlightDAO;

@RestController
public class FlightController {
	
	
	@Autowired
	private FlightDAO flightDAO;
	
	
	@RequestMapping(value = "/flights", method = RequestMethod.GET)
    public ResponseEntity<List<Flight>> getAllFlights() {
		
		return new ResponseEntity<>(flightDAO.getAllFlights(), HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/flight/carrier/{carrier}", method = RequestMethod.GET)
    public List<Flight> getAllFlightsByCarrier(@PathVariable("carrier") String carrier) {
		
		List<Flight> flights = flightDAO.findByCarrier(carrier);
		
		return flights;
	}

	@RequestMapping(value = "/flight/origin/{origin}", method = RequestMethod.GET)
    public List<Flight> getAllFlightsByOrigin(@PathVariable("origin") String origin) {
		
		List<Flight> flights = flightDAO.findByOrigin(origin);
		
		return flights;
	}
	
	@RequestMapping(value = "/flight/destination/{destination}", method = RequestMethod.GET)
    public List<Flight> getAllFlightsByDestination(@PathVariable("destination") String destination) {
		
		List<Flight> flights = flightDAO.findByDestination(destination);
		
		return flights;
	}
}
