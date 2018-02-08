package com.acc.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionalException;
import org.apache.log4j.*;
import org.hibernate.Session;

import com.acc.entity.Employee;

/**
 * desc.......
 * 
 * @author khalid.a.khan
 *
 */
public class EmployeeDao {
	   public static int countupdate=0,countinsert=0;
	private static org.apache.log4j.Logger log = Logger.getLogger(EmployeeDao.class);
	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeeProject");

	public Employee searchDao(int empid) {

		Employee emp = new Employee();

		EntityManager manager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();

			transaction.begin();

			emp = manager.find(Employee.class, empid);
		} catch (Exception e) {
			log.info("Search failed....");
		} finally {
			manager.close();
		}
		return emp;
	}

	public int insertupdateDao(Employee emp) {
		int status = 0;
		int empid;
		EntityManager manager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			System.out.println(emp.getEmpid());
			transaction.begin();
			if (emp.getEmpid() == 0) {
				empid = (Integer) manager.createQuery("select max(e.empid) from Employee e").getSingleResult();
				emp.setEmpid(empid + 1);
				manager.persist(emp);
			}
			else 
				manager.merge(emp);
			transaction.commit();
			status = 1;
		} 
		
		catch (TransactionalException e) {
			status = 0;
			if (transaction != null)
				transaction.rollback();
			log.info("Insert failed....");
		} finally {
			manager.close();
		}

		return status;
	}

	/*public Map<Integer, String> insertbulk() {
		Employee emp = new Employee();
		Employee employee = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		int status = 0;

		try (BufferedReader br = new BufferedReader(new FileReader("employee.txt"))) {
			String line = null;

			while ((line = br.readLine()) != null) {
				status = 0;
				String tmp[] = line.split(",");

				emp.setEmpid(Integer.parseInt(tmp[0]));
				emp.setName(tmp[1]);
				emp.setDesignation(tmp[2]);
				emp.setTechnology(tmp[3]);
				emp.setDeliveryGroup(tmp[4]);
				emp.setLocation(tmp[5]);
				employee = searchDao(emp.getEmpid());
				if (employee != null) {

					status = updateDao(emp);
				} else {
					status = insertDao(emp);
				}
				if (status == 1) {
					map.put(emp.getEmpid(), "success");
				} else
					map.put(emp.getEmpid(), "failure");

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;

	}*/
	
	  public Map<Integer, String> insertbulk(String fileName) {
	         Employee emp = new Employee();
	      
	         Employee employee = null;
	         Map<Integer, String> map = new HashMap<Integer, String>();
	         int status = 0;

			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	             String line = null;

	             while ((line = br.readLine()) != null) {
	                 status = 0;
	                 String tmp[] = line.split(",");
	                 int i=-1;
	                 if(tmp.length==6) {
	                     i=0;
	                 emp.setEmpid(Integer.parseInt(tmp[i]));
	                 }
	                 emp.setName(tmp[i+1]);
	                 emp.setDesignation(tmp[i+2]);
	                 emp.setTechnology(tmp[i+3]);
	                 emp.setDeliveryGroup(tmp[i+4]);
	                 emp.setLocation(tmp[i+5]);
	                 employee = searchDao(emp.getEmpid());
	                 if (employee != null) {

	                     status = insertupdateDao(emp);
	                     countupdate++;
	                  
	                 } else {
	                     status = insertupdateDao(emp);
	                       countinsert++;
	                 }
	                 if (status == 1) {
	                     map.put(emp.getEmpid(), "success");
	                 } else
	                     map.put(emp.getEmpid(), "failure");

	             }
	         }
	         catch (FileNotFoundException e) {
	             e.printStackTrace();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }

	         return map;

	     }

	

	public int deleteDao(int empid) {
		int status = 0;
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		Employee emp = new Employee();
		try {
			status = 1;
			transaction = manager.getTransaction();
			transaction.begin();
			emp = manager.find(Employee.class, empid);
			manager.remove(emp);
			transaction.commit();
		} catch (TransactionalException e) {
			status = 0;
			log.info("Delete failed....");

		} finally {
			manager.close();
		}

		return status;
	}

	public List<Employee> showAlltDao() {
		List employees = null;
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			employees = manager.createQuery("select e from Employee e", Employee.class).getResultList();
		} catch (TransactionalException e) {
			log.info("showAll failed....");

		} finally {
			manager.close();
		}
		return employees;
	}

	/*public int updateDao(Employee emp) {
		int status = 0;
		EntityManager manager = entityManagerFactory.createEntityManager();
		Session session = manager.unwrap(Session.class);
		session.saveOrUpdate(emp);
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			Employee em = new Employee();
			
			 * em = manager.find(Employee.class, emp.getEmpid());
			 * em.setDeliveryGroup(emp.getDeliveryGroup());
			 * em.setDesignation(emp.getDesignation()); em.setEmpid(emp.getEmpid());
			 * em.setLocation(emp.getLocation()); em.setName(emp.getName());
			 * em.setTechnology(emp.getTechnology());
			 
			manager.merge(emp);
			transaction.commit();
			status = 1;

		} catch (TransactionalException e) {
			status = 0;
			log.info("Update failed....");

		} finally {
			manager.close();
		}

		return status;
	}*/
}