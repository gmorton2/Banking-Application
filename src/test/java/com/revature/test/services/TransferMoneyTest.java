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
//import com.revature.model.Checkings;
//import com.revature.model.Customer;
//import com.revature.model.Savings;
//
//public class TransferMoneyTest {
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
//		Customer customer = new Customer("Garinn Morton", "gmorton", "secure", 123,111);
//		//double balance, int accountID, Customer customer,String type
//		Account a1 = new Checkings(100.00, 222, customer,"Checking");
//		Account a2 = new Savings(300.00, 223, customer,"Saving");
//
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(a1);
//		accounts.add(a2);
//		String from = "Saving";
//		String to="Checking";
//		double amount=100.00;
//		
//		Account a3 = new Checkings(200.00, 222, customer,"Checking");
//		Account a4 = new Savings(200.00, 223, customer,"Saving");
//
//		List<Account> updatedAccounts = new ArrayList<Account>();
//		updatedAccounts.add(a3);
//		updatedAccounts.add(a4);
//
//		// create a mock userDAO so it returns the list that was just created
//		Mockito.when(cDAO.getAllAccounts(customer)).thenReturn(accounts);
//		//Customer customer,String from,String to,double amount
//		Mockito.when(cDAO.transferMoneyFromAccounts(customer,from,to,amount)).thenReturn(updatedAccounts);
//
//		List<Account> val = cDAO.transferMoneyFromAccounts(customer,from,to,amount);
//		System.out.println(updatedAccounts.toString());
//		System.out.println(val.toString());
//
//		assertEquals(updatedAccounts, val);
//	} 
//}
