package com.suptrip.dao;

import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;

public interface UsersDao {
	void addUser(Users user);
	void removeUser(Users user);
	void updateUser(Users user);
	void addTripInBag (Users user,Trip trip );
	void removeTripInbag(Users user, Trip trip);
	
	
	
	

}
