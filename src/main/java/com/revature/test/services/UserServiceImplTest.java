package com.revature.test.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.model.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class UserServiceImplTest {
	private UserService service;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Before all tests");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("After Class");
	}
	
	@Before
	public void setupBefore() {
		System.out.println("Run before each test");
		service = new UserServiceImpl();
	}
	
	@After
	public void tearDown() {
		System.out.println("After Test");
	}
	
	@Test
	public void testVerifySuccess() {
		User success = new User("Garinn Morton","gmorton","secure",123);
		User u2 = new User("f","b","w",222);
		User u = new User("Garinn Morton","gmorton","secure",123);
		List<User> users = new ArrayList<User>();
		users.add(u2);
		users.add(success);

		User val = service.logIn(users, u);
		System.out.println(success.getUserName());
		System.out.println(val.getUserName());
		assertEquals(success, val);
	}
	
}
