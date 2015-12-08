package com.suptrip.dao;

import java.util.List;

import com.suptrip.entities.Trip;

public interface BagDao {
	void addTripInBag(Trip trip);
	void removeTripInBag(Trip trip);
	List<Trip> getAllTripInBag();
	
}
