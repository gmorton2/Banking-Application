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
//import com.revature.dao.EmployeeDAO;
//import com.revature.model.Account;
//import com.revature.model.Checkings;
//import com.revature.model.Customer;
//import com.revature.model.Savings;
//
//public class GetAllPendingAccountsTest {
//	@Mock
//	private static EmployeeDAO eDAO;
//
//	@BeforeClass
//	public static void setUpBeforeClass() {
//		System.out.println("Before all tests");
//		eDAO = Mockito.mock(com.revature.dao.EmployeeDAOImpl.class);
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
//		Customer c1 = new Customer("Garinn Morton", "gmorton", "secure", 123,111);
//		Customer c2 = new Customer("Bryn Portella", "bportella", "revature", 456,222);
//		Account a1 = new Savings(100.00, 222, c1,"Saving");
//		Account a2 = new Checkings(300.00, 223, c2,"Checking");
//
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(a1);
//		accounts.add(a2);
//
//		// create a mock userDAO so it returns the list that was just created
//		Mockito.when(eDAO.getAllPendingAccounts()).thenReturn(accounts);
//
//		List<Account> val = eDAO.getAllPendingAccounts();
//		System.out.println(accounts.toString());
//		System.out.println(val.toString());
//
//		assertEquals(accounts, val);
//	} 
//}
