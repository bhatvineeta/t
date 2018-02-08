package com.acc.service;

import java.util.List;

import com.acc.dao.EmployeeDao;
import com.acc.entity.Employee;

public class EmployeeService {

	public Employee searchEmployee(int empid) {

		EmployeeDao empdao = new EmployeeDao();

		return empdao.searchDao(empid);

	}

	public int updateEmployee(Employee emp) {
		EmployeeDao empdao = new EmployeeDao();
		return empdao.insertupdateDao(emp);

	}

	public int insertEmployee(Employee emp) {

		EmployeeDao empdao = new EmployeeDao();
		return empdao.insertupdateDao(emp);
	}

	public int deleteEmployee(int empid) {

		EmployeeDao empdao = new EmployeeDao();
		return empdao.deleteDao(empid);
	}

	public List<Employee> showAllEmployee() {

		EmployeeDao empdao = new EmployeeDao();
		return empdao.showAlltDao();

	}

}
