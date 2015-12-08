package com.suptrip.entities;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="BAG")
public class Bag {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idBag;
	
	@OneToOne(mappedBy="bag")
	private Users idUserBag;
	
	
	public long getIdBag() {
		return idBag;
	}
	public void setIdBag(long idBag) {
		this.idBag = idBag;
	}
	
	
	

}
