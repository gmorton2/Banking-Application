//package com.revature.test.services;
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
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import com.revature.dao.CustomerDAO;
//import com.revature.model.Account;
//import com.revature.model.Customer;
//
//public class GetAllAccountsForCustomerTest {
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
//		Account a1 = new Account(100.00, 222, customer);
//		Account a2 = new Account(300.00, 223, customer);
//
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(a1);
//		accounts.add(a2);
//
//		// create a mock userDAO so it returns the list that was just created
//		Mockito.when(cDAO.getAllAccounts(customer)).thenReturn(accounts);
//
//		List<Account> val = cDAO.getAllAccounts(customer);
//		System.out.println(accounts.toString());
//		System.out.println(val.toString());
//
//		assertEquals(accounts, val);
//	} 
//}
