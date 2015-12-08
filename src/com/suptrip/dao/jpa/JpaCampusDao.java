package com.suptrip.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.suptrip.dao.CampusDao;
import com.suptrip.entities.Campus;

public class JpaCampusDao implements CampusDao {
	EntityManagerFactory emf;
	 public JpaCampusDao(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
		 this.emf=emf;
	}

	@Override
	public void addCampus(Campus campus) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(campus);
			em.getTransaction().commit();
			
		} finally {
			// TODO: handle finally claus
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
	}

	@Override
	public void removeCampus(Campus campus) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(em.merge(campus));
			em.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				
			}
		}
		
	}

	@Override
	public List<Campus> getAllCampus() {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try {
			Query query=em.createQuery("SELECT c FROM CAMPUS as c ");
			return query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
	}

}
