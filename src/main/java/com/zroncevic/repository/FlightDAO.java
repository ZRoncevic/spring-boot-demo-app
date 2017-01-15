package com.zroncevic.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.zroncevic.model.Flight;

@Repository
public class FlightDAO {

	private List<Flight> flights;
	
	@PostConstruct
	private void init() {
		flights = new ArrayList<>();
		flights.add(new Flight(1, "LH", "FRA", "MUC", "100", new Date()));
		flights.add(new Flight(2, "LH", "FRA", "MUC", "101", new Date()));
		flights.add(new Flight(3, "OU", "MUC", "ZAG", "411", new Date()));
		flights.add(new Flight(4, "OU", "ZAG", "FRA", "400", new Date()));
		flights.add(new Flight(5, "EN", "HAM", "TXL", "210", new Date()));
		flights.add(new Flight(6, "EN", "FRA", "TXL", "100", new Date()));
		flights.add(new Flight(7, "UA", "LAX", "NYC", "765", new Date()));
		flights.add(new Flight(8, "UA", "NYC", "PHX", "100", new Date()));
		flights.add(new Flight(9, "WX", "BOS", "MUC", "321", new Date()));
		flights.add(new Flight(10, "WX", "ORL", "ZAG", "642", new Date()));
		flights.add(new Flight(11, "LH", "MUC", "HAM", "200", new Date()));
		flights.add(new Flight(12, "LH", "FRA", "THX", "500", new Date()));
    }
	
	public void addNewFlight(Flight newFlight){
		flights.add(newFlight);
	}

	public List<Flight> getAllFlights() {
		return flights;
	}
	
	public List<Flight> findByCarrier(String carrier){
		
		return (List<Flight>) flights.stream() 
				.filter(flight -> carrier.equals(flight.getCarrier()))
				.collect(Collectors.toList());
	}
	
	public List<Flight> findByOrigin(String origin){
		
		return (List<Flight>) flights.stream() 
				.filter(flight -> origin.equals(flight.getOrigin()))
				.collect(Collectors.toList());
	}
	
	public List<Flight> findByDestination(String destination){
		
		return (List<Flight>) flights.stream() 
				.filter(flight -> destination.equals(flight.getDestination()))
				.collect(Collectors.toList());
	}
	
}
