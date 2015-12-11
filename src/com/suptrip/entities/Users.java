package com.suptrip.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="USER")
public class Users implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idBooster;
	
	private String firstName;
	private String lastName;
	private String emailAdress;
	private String passwd;
	
	
	@ManyToOne
	@JoinColumn(name="ID_CAMPUS")
	private Campus idCampus;
	
	@ManyToMany
	@JoinTable(name="USER_TRIP")
	private List<Trip> trip;
	
	
	public Campus getIdCampus() {
		return idCampus;
	}
	public void setIdCampus(Campus idCampus) {
		this.idCampus = idCampus;
	}
	
	public List<Trip> getTrip() {
		return trip;
	}
	public void setTrip(List<Trip> trip) {
		this.trip = trip;
	}
	public long getIdBooster() {
		return idBooster;
	}
	public void setIdBooster(long idBooster) {
		this.idBooster = idBooster;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Campus getIdcampus() {
		return idCampus;
	}
	public void setIdcampus(Campus idcampus) {
		this.idCampus = idcampus;
	}
	
	
	
}
