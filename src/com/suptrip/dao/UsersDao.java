package com.suptrip.dao;

import java.util.List;

import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;

public interface UsersDao {
	void addUser(Users user);
	void removeUser(Users user);
	void updateUser(Users user);
	void addTripInBag (Users user,Trip trip );
	void removeTripInbag(Users user, Trip trip);
	Users getUserById(Long id) ;
	List<Users> getUserAllUsers() ;
	
	

}
