//
//package com.revature.test.services;
//
//import org.mockito.Mock;
//
//import org.mockito.Mockito;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.revature.dao.UserDAO;
//import com.revature.dao.UserDAOImpl;
//import com.revature.model.Customer;
//import com.revature.model.User;
//import com.revature.services.UserService;
//import com.revature.services.UserServiceImpl;
//
//public class MakeCustomerAccountTest {
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
//	public void makeAccountSuccess() {
//		User u = new User("Garinn Morton", "gmorton", "secure", 123);
//		Customer success = new Customer("Garinn Morton", "gmorton", "secure", 123, 1111);
//
//		service = new UserServiceImpl(new UserDAOImpl());
//		Mockito.when(userDAO.createAccount(u)).thenReturn(success);
//
//		Customer val = service.regsiterForCustomerAccount(u);
//
//		System.out.println(success.toString());
//		System.out.println(val.toString());
//
//		assertEquals(success, val);
//	}
//}
