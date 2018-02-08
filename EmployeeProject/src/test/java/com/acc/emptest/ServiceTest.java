package com.acc.emptest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acc.dao.EmployeeDao;
import com.acc.entity.Employee;
import com.acc.service.EmployeeService;

class ServiceTest {
	private Employee emp;
	private EmployeeService empservice;

	@BeforeEach
	void setUp() throws Exception {
		emp = new Employee();
		empservice = new EmployeeService();
	}

	@AfterEach
	void tearDown() throws Exception {
		emp = null;
		empservice = null;
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testsearch() {

		emp = empservice.searchEmployee(1000);
		assertEquals(1000, emp.getEmpid());

	}

	@Test
	void testdeleteemployee() {
		int status = 0;
		emp = empservice.searchEmployee(1002);
		status = empservice.deleteEmployee(emp.getEmpid());
		assertEquals(1, status);
	}

	@Test
	void testupdateemployee() {
		emp = empservice.searchEmployee(1000);
		emp.setName("diffuser");
		emp.setDesignation("ASE");
		emp.setTechnology("oracle");
		int status = empservice.updateEmployee(emp);
		assertEquals(1, status);

	}

	@Test
	void testinsertemployee() {
		int status = 0;
		emp.setEmpid(1002);
		emp.setName("seconduser");
		emp.setLocation("bangalore");
		emp.setTechnology("oracle");
		emp.setDeliveryGroup("idc");
		emp.setDesignation("ASE");
		status = empservice.insertEmployee(emp);
		assertEquals(1, status);
	}

	@Test
	void testshowemployee() {
		List list = empservice.showAllEmployee();
		assertEquals(2, list.size());
	}

}
