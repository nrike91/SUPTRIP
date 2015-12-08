package com.suptrip.util;


	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
	
	public class PersistanceManager {
		
		private static EntityManagerFactory emf;
		
		public static EntityManagerFactory getEntityManagerFactory() {
	        if (emf == null) {
	            emf = Persistence.createEntityManagerFactory("my-PU");
	        }
	        return emf;
	    }

	    public static void closeEntityManagerFactory() {
	        if (emf != null && emf.isOpen()) {
	            emf.close();
	        }
	    }
	}
	


