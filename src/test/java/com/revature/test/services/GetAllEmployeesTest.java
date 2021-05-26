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
//import com.revature.model.Employee;
//
//public class GetAllEmployeesTest {
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
//		Employee e1 = new Employee("Garinn Morton", "gmorton", "secure", 123,111);
//		Employee e2 = new Employee("Bryn Portella", "bportella", "revature", 456,222);
//
//		List<Employee> employees= new ArrayList<Employee>();
//		employees.add(e1);
//		employees.add(e2);
//
//		Mockito.when(eDAO.getAllEmployees()).thenReturn(employees);
//
//		List<Employee> val = eDAO.getAllEmployees();
//		System.out.println(employees.toString());
//		System.out.println(val.toString());
//
//		assertEquals(employees, val);
//	}
//}
