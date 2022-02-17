package com.bookstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.User;
import com.bookstoredb.entity.Category;

public class CategoryTest {
	
	public static void main(String[] args) { 
		
		Category newCat = new Category("Effective Java!");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreProject");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
			
		// this logs if for someone who get stuck with Eclipse IDE for Java development
		// this is test comment, the content is not special so much but this comment 
		// yield a meaning to everyone who is living inside this scope!
		// this is User test class to test the process of generating data by Hibernate 
		
		entityManager.getTransaction().begin();
		entityManager.persist(newCat);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	
		System.out.println("A category object was persisted successfully!"); 
	}
}
