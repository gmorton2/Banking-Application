//package com.revature.test.services;
//
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.revature.dao.UserDAO;
//import com.revature.model.User;
//import com.revature.services.UserService;
//import com.revature.services.UserServiceImpl;
//
//public class LoginToUserAccountTest {
//
//	private UserService service;
//
//	@Mock
//	private static UserDAO userDAO;
//
//	@BeforeClass
//	public static void setUpBeforeClass() {
//		System.out.println("Before all tests");
//		userDAO = Mockito.mock(com.revature.dao.UserDAOImpl.class);
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() {
//		System.out.println("After Class");
//	}
//
//	@Before
//	public void setupBefore() {
//		System.out.println("Run before each test");
//		service = new UserServiceImpl(userDAO);
//	}
//
//	@After
//	public void tearDown() {
//		System.out.println("After Test");
//	}
//
//	@Test
//	public void testVerifySuccess() {
//
//		User success = new User("Garinn Morton", "gmorton", "secure", 123);
//		User u2 = new User("f", "b", "w", 222);
//		User u = new User("Garinn Morton", "gmorton", "secure", 123);
//		String username = success.getUserName();
//		String password = success.getPassword();
//		List<User> users = new ArrayList<User>();
//		users.add(u2);
//		users.add(success);
//
//		// create a mock userDAO so it returns the list that was just created
//		Mockito.when(userDAO.getAllUsers()).thenReturn(users);
//
//		User val = service.logIn(username,password);
//		System.out.println(success.toString());
//		System.out.println(val.toString());
//
//		assertEquals(success, val);
//	}
//}
