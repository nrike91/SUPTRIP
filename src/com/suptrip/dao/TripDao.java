package com.suptrip.dao;

import java.util.List;

import com.suptrip.entities.Trip;

public interface TripDao {
	void addTrip(Trip trip);
	
	List<Trip> getAllTrip();
	List<Trip> getTripByString(String value);
	
	void removeTrip(Trip trip);
	void updateTrip(Trip trip);
	Trip findTripById(Long id);
	

}
