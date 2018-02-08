package com.acc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.acc.entity.Employee;
import com.acc.service.EmployeeService;

@Controller
public class EmployeeController {

	String allemp = "/allemployees";
	String allemployee = "allemployee";
	private static org.apache.log4j.Logger log = Logger.getLogger(EmployeeController.class);

	@RequestMapping("/insert.htm")
	public ModelAndView insertEmployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int status = 0;
		Employee emp = new Employee();
		emp.setDeliveryGroup(request.getParameter("deliveryGroup"));
		emp.setName(request.getParameter("name"));

		emp.setLocation(request.getParameter("location"));
		emp.setDesignation(request.getParameter("designation"));
		emp.setTechnology(request.getParameter("technology"));
		EmployeeService empSer = new EmployeeService();
		status = empSer.insertEmployee(emp);

		if (status >= 1) {
			mv.addObject("REGISTRATIONSTATUSMESSAGE", "Employee Registered Succesfully !!!");
			log.info("Registration successful");
		
		} else {
			mv.addObject("REGISTRATIONSTATUSMESSAGE",
					"EMPLOYEE already exists.. please register again with different employee id");
			log.info("Registration failed");	
		}
		mv.setViewName("empform");
		return mv;

	}

	@RequestMapping("/getallemployees.htm")
	public ModelAndView getallEmployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		EmployeeService empservice = new EmployeeService();
		List<Employee> list = empservice.showAllEmployee();
		mv.addObject(allemployee, list);
		mv.setViewName(allemp);
		return mv;

	}

	@RequestMapping("/updatepage.htm")
	public ModelAndView getUpdate(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		EmployeeService empSer = new EmployeeService();
		int empId = Integer.parseInt(request.getParameter("employeeId"));
		Employee emp = empSer.searchEmployee(empId);

		mv.addObject("emp", emp);
		mv.setViewName("/updateform");
		return mv;
	}

	@RequestMapping("/modify.htm")
	public ModelAndView getModify(HttpServletRequest request, HttpServletResponse response) {
		int status = 0;

		ModelAndView mv = new ModelAndView();
		Employee emp = new Employee();
		EmployeeService empSer = new EmployeeService();
		emp.setDeliveryGroup(request.getParameter("deliveryGroup"));
		emp.setName(request.getParameter("name"));
		emp.setEmpid(Integer.parseInt(request.getParameter("empid")));
		emp.setLocation(request.getParameter("location"));
		emp.setDesignation(request.getParameter("designation"));
		emp.setTechnology(request.getParameter("technology"));
		status = empSer.updateEmployee(emp);
		List<Employee> list = empSer.showAllEmployee();
		mv.addObject(allemployee, list);
		mv.setViewName(allemp);
		if (status >= 1) {
			mv.addObject("UPDATESTATUSMESSAGE", "Employee Updated Succesfully !!!");
			log.info("Updated successfully");
			
		} else {
			mv.addObject("UPDATESTATUSMESSAGE", "EMPLOYEE Updation failed");
			log.info("Updation unsuccessful");
		}
		return mv;
	}

	@RequestMapping("/search.htm")
	public ModelAndView searchEmployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		EmployeeService empservice = new EmployeeService();
		List<Employee> list = new ArrayList();
		Employee emp = empservice.searchEmployee(Integer.parseInt(request.getParameter("search_empid")));
		list.add(emp);
		mv.addObject(allemployee, list);
		mv.setViewName(allemp);
		return mv;
	}

	@RequestMapping("/deletepage.htm")
	public ModelAndView getDelete(HttpServletRequest request, HttpServletResponse response) {
		int status = 0;

		ModelAndView mv = new ModelAndView();
		EmployeeService empSer = new EmployeeService();
		int empid = Integer.parseInt(request.getParameter("empid"));
		Employee emp = empSer.searchEmployee(empid);
		if (emp != null) {
			status = empSer.deleteEmployee(empid);
		}
		List<Employee> list = empSer.showAllEmployee();
		mv.addObject(allemployee, list);

		if (status >= 1) {
			mv.addObject("DELETESTATUSMESSAGE", "Employee Deleted Succesfully !!!");
			log.info("Deleted successfully");
			mv.setViewName(allemp);
		} else {
			mv.addObject("DELETESTATUSMESSAGE", "EMPLOYEE Deletion failed");
			log.info("Deletion unsuccessful");
			mv.setViewName(allemp);

		}

		return mv;

	}

}
