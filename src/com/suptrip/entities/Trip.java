package com.suptrip.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TRIP")
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idTrip;
	
	
	private Date date;
	
	@ManyToMany(mappedBy="trip")
	private List<Campus> campus=new ArrayList<Campus>();
	
	public List<Campus> getCampus() {
		return campus;
	}
	public void setCampus(List<Campus> campus) {
		this.campus = campus;
	}
	private String description;
	public long getIdTrip() {
		return idTrip;
	}
	public void setIdTrip(long idTrip) {
		this.idTrip = idTrip;
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
