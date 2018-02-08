package com.acc.dao;

public class EmployeeMgmtException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeMgmtException(String string) {
		super(string);
	}

	@Override
	public String getMessage() {
		return ("Error in Emp MGMT " + super.getMessage());
	}
	
	public static void main(String[] args) {
		EmployeeMgmtException employeeMgmtException = new EmployeeMgmtException("Test - classname - ");
		System.out.println(employeeMgmtException.getMessage());
		
	}
}
