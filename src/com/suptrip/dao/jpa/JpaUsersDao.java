package com.suptrip.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.suptrip.dao.UsersDao;
import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;

public class JpaUsersDao implements UsersDao {
	EntityManagerFactory emf;
	public  JpaUsersDao(EntityManagerFactory emf) {
		this.emf=emf;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();;
		try {
			em.persist(user);
			em.getTransaction().commit();
			
			
		} finally  {
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
		
			// TODO: handle exception
		}
		em.close();
		
	}

	@Override
	public void removeUser(Users user) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(em.merge(user));
			em.getTransaction().commit();
			
		} finally {
			// TODO: handle finally clause
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
		}
		em.close();
	}

	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(user);
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
	public void addTripInBag(Users user, Trip trip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTripInbag(Users user, Trip trip) {
		// TODO Auto-generated method stub
		
	}

}
