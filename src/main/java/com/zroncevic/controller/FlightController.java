package com.zroncevic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/add/flight", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		
		if(flight.isValidFlight()) {
			flightDAO.addNewFlight(flight);
			return new ResponseEntity<>(flight, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(flight, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value = "/flight/carrier/{carrier}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> getAllFlightsByCarrier(@PathVariable("carrier") String carrier) {

		List<Flight> flights = flightDAO.findByCarrier(carrier);

		if (flights == null) {
			return new ResponseEntity<>(flights, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(flights, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/flight/origin/{origin}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> getAllFlightsByOrigin(@PathVariable("origin") String origin) {
		
		List<Flight> flights = flightDAO.findByOrigin(origin);
		
		if (flights == null) {
			return new ResponseEntity<>(flights, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(flights, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/flight/destination/{destination}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> getAllFlightsByDestination(@PathVariable("destination") String destination) {
		
		List<Flight> flights = flightDAO.findByDestination(destination);
		
		if (flights == null) {
			return new ResponseEntity<>(flights, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(flights, HttpStatus.OK);
		}
	}
}
