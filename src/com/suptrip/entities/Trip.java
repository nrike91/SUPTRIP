package com.suptrip.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TRIP")
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idTrip;
	
	@Column
	private Date date;
	@Column
	private String description;
	
	
	@ManyToMany
	@JoinTable(name="BAG_TRIP")
	private List<Bag> tripBag;
	
	
	
	public long getIdTrip() {
		return idTrip;
	}
	public void setIdTrip(long idTrip) {
		this.idTrip = idTrip;
	}
	
	public List<Bag> getBag() {
		return tripBag;
	}
	public void setBag(List<Bag> bag) {
		this.tripBag = bag;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
