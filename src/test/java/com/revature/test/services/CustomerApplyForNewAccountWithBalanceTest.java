//package com.revature.test.services;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import com.revature.dao.CustomerDAO;
//import com.revature.model.Account;
//import com.revature.model.Customer;
//import com.revature.services.CustomerService;
//import com.revature.services.CustomerServiceImpl;
//
//public class CustomerApplyForNewAccountWithBalanceTest {
//	private CustomerService service;
//
//	@Mock
//	private static CustomerDAO cDAO;
//
//	@BeforeClass
//	public static void setUpBeforeClass() {
//		System.out.println("Before all tests");
//		cDAO = Mockito.mock(com.revature.dao.CustomerDAOImpl.class);
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
//		service = new CustomerServiceImpl(cDAO);
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
//		Customer customer = new Customer("Garinn Morton", "gmorton", "secure", 123,111);
//		Account success = new Account(100.00, 222, customer);
//
//		// create a mock userDAO so it returns the list that was just created
//		Mockito.when(cDAO.applyForNewAccount(customer)).thenReturn(success);
//
//		Account val = cDAO.applyForNewAccount(customer);
//		System.out.println(success.toString());
//		System.out.println(val.toString());
//
//		assertEquals(success, val);
//	}
//}
