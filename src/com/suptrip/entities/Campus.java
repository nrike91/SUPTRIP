package com.suptrip.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="CAMPUS")
public class Campus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCampus;
	@Column
	private String campusName;
	@Column
	private String location;
	@OneToMany(mappedBy="idCampus")
	private List<Users> users;
	
	@ManyToMany 
	@JoinTable(name="CAMPUS_TRIP")
	private List<Trip> trip=new ArrayList<Trip>();
	
	
	
	public List<Trip> getTrip() {
		return trip;
	}
	public void setTrip(List<Trip> trip) {
		this.trip = trip;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	public long getIdCampus() {
		return idCampus;
	}
	public void setIdCampus(long idCampus) {
		this.idCampus = idCampus;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
	
	

}
