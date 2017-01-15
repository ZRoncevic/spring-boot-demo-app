package com.zroncevic.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Flight {
	
	private int id;
	private String carrier;
	private String origin;
	private String destination;
	private String flightNumber;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date departureDate;
	
	public Flight(){}
	
	public Flight(int id, String carrier, String origin, String destination, String flightNumber, Date departureDate) {
		this.id = id;
		this.carrier = carrier;
		this.origin = origin;
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		return result;
	}

	//Each flight has a natural key of carrier, flight number, origin and departure date
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (carrier == null) {
			if (other.carrier != null)
				return false;
		} else if (!carrier.equals(other.carrier))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", carrier=" + carrier + ", origin=" + origin + ", destination=" + destination
				+ ", flightNumber=" + flightNumber + ", departureDate=" + departureDate + "]";
	}

}
