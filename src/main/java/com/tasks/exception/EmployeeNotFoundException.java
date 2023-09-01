package com.tasks.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception{
	
	public EmployeeNotFoundException() {
		
	}
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}

}
