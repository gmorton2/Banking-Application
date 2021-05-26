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
//import com.revature.model.Customer;
//
//public class GetAllCustomersTest {
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
//		Customer c1 = new Customer("Garinn Morton", "gmorton", "secure", 123,111);
//		Customer c2 = new Customer("Bryn Portella", "bportella", "revature", 456,222);
//
//		List<Customer> customers= new ArrayList<Customer>();
//		customers.add(c1);
//		customers.add(c2);
//
//		Mockito.when(cDAO.getAllCustomers()).thenReturn(customers);
//
//		List<Customer> val = cDAO.getAllCustomers();
//		System.out.println(customers.toString());
//		System.out.println(val.toString());
//
//		assertEquals(customers, val);
//	}
//}
