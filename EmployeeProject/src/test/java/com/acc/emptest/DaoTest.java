package com.acc.emptest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acc.dao.EmployeeDao;
import com.acc.entity.Employee;

class DaoTest {
	private Employee emp;
	private EmployeeDao empdao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		emp = new Employee();
		empdao = new EmployeeDao();
	}

	@AfterEach
	void tearDown() throws Exception {
		emp = null;
		empdao = null;
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void insertemployee() {
		int status = 0;
		//emp.setEmpid(1001);
		emp.setName("seconduser");
		emp.setLocation("bangalore");
		emp.setTechnology("oracle");
		emp.setDeliveryGroup("idc");
		emp.setDesignation("ASE");
		status = empdao.insertupdateDao(emp);
		assertEquals(1, status);
	}

	@Test
	void searchemployee() {
		emp = empdao.searchDao(1010);
		assertEquals(1010, emp.getEmpid());

	}

	@Test
	void deleteemployee() {
		int status = 0;
		emp = empdao.searchDao(1010);
		status = empdao.deleteDao(emp.getEmpid());
		assertEquals(1, status);
	}

	@Test
	void updateemployee() {
		emp = empdao.searchDao(1009);
		emp.setName("diffuser");
		emp.setDesignation("SSE");
		emp.setTechnology("oracle");
		int status = empdao.insertupdateDao(emp);
		assertEquals(1, status);

	}

	@Test
	void show() {
		List list = empdao.showAlltDao();
		assertEquals(1, list.size());
	}
	
	@Test
	void insertBulk()
	{   
		Map<Integer,String> map=new HashMap<Integer,String>(); 
		map=empdao.insertbulk("employee2.txt");
		assertEquals(1,empdao.countupdate);
		
		// file exists
		// file do not exists
		// file is empty
		// has only insert
		// has only update
		//has both
		//
	}
   
	
	/*@Test
	void updateBulk()
	{   
		Map<Integer,String> map=new HashMap<Integer,String>(); 
		map=empdao.insertbulk("employee2.txt");
		assertEquals(1,empdao.countupdate);
		
	}*/
   
	
}
