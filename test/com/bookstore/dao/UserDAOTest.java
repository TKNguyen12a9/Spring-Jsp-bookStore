package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.User;

import java.util.List;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setupClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreProject");
		entityManager = entityManagerFactory.createEntityManager();
		
		userDAO = new UserDAO(entityManager);
	}
	
	@Test
	public void testCreateUser() {
		User user1 = new User();
		user1.setEmail("sam@test.com");
		user1.setFullname("Sam");
		user1.setPassword("@kien12a99");
		
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreProject");
		entityManager = entityManagerFactory.createEntityManager();
		
		userDAO = new UserDAO(entityManager);
		user1 = userDAO.create(user1);
		
		entityManager.close();
		entityManagerFactory.close();
		
		assertTrue(user1.getUserId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
		User user = new User();
		
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreProject");
		entityManager = entityManagerFactory.createEntityManager();
		
		userDAO = new UserDAO(entityManager);
		user = userDAO.create(user);
		
		entityManager.close();
		entityManagerFactory.close();
		
		assertTrue(user.getUserId() > 0);
	}
		
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setUserId(1);
		user.setFullname("kane nguyen");
		user.setEmail("kane@test.com");
		user.setPassword("mysecret");
		
		user = userDAO.update(user);
		String expected = "mysecret"; // expected password after changed
		String actual = user.getPassword(); // actual password after changed
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUserFound() {
		Integer userId = 1;
		User user = userDAO.get(userId);
		if (user != null) {
			System.out.println(user.getEmail());
		}
		assertNotNull(user);
	}
	
	@Test 
	public void testGetUserNotFound() {
		Integer userId = 10;
		User user = userDAO.get(userId);
		if (user != null) {
			System.out.println(user.getEmail());
		}
		assertNull(user);
	}
	
	@Test
	public void testUserDelete() {
		Integer userId = 2;
		userDAO.delete(userId);
		User user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testNonExistedUserDelete() {
		Integer userId = 99;
		userDAO.delete(userId);
		User user = userDAO.get(userId);
		if (user == null) {
			System.out.println("user does not exist!");
		}
	}
	
	@Test 
	public void testListAll() {
		List<User> userList = userDAO.listAll(); 
		for (User user: userList) {
			System.out.println(user.getEmail());
		}
		assertTrue(userList.size() > 0);
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		System.out.println(totalUsers);
		assertEquals(1, totalUsers);
	}
}
















