package com.suptrip.dao;

import java.util.List;

import com.suptrip.entities.Campus;

public interface CampusDao {
	void addCampus(Campus campus);
	void removeCampus(Campus campus);
	List<Campus> getAllCampus();
	Campus getCampusById(Long id);

}
