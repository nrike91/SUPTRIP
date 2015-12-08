package com.suptrip.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.catalina.User;

import com.suptrip.dao.TripDao;
import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;

public class JpaTripDao implements TripDao{
	EntityManagerFactory emf;
	public JpaTripDao(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
		this.emf=emf;
	}

	@Override
	public void addTrip(Trip trip) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager(); 
		em.getTransaction().begin();
		try {
			em.persist(trip);
			em.getTransaction().commit();
			
		} finally {
			// TODO: handle finally clause
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				
			}
		}
		em.close();
		
	}


	@Override
	public Trip findTripById(Long id) {
		// TODO Auto-generated method stub
	EntityManager em=emf.createEntityManager(); 
	try {
		Query query= em.createQuery("SELECT c FROM Trip As c where c.idTrip=:id");
		query.setParameter("id", id);
		return (Trip) query.getSingleResult();
		
	} catch (NoResultException e) {
		return null;
		// TODO: handle exception
	}finally {
		em.close();
	}
		
	}

	@Override
	public List<Trip> getAllTripListByCampusName() {
		EntityManager em=emf.createEntityManager(); 
		try {
			Query query = em.createQuery("SELECT c FROM TRIP AS c");
			return query.getResultList();
		
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}finally {
			em.close();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTrip(Trip trip) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(em.merge(trip));
			em.getTransaction().commit();
			
			
		} finally {
			// TODO: handle finally clause
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				
			}
			
		}
		em.close();
		
	}

	@Override
	public void updateTrip(Trip trip) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(trip);
			em.getTransaction().commit();
			
		} finally {
			// TODO: handle finally clause
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
	}

	

}
