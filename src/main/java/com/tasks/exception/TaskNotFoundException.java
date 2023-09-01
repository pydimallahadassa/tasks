package com.tasks.exception;

@SuppressWarnings("serial")
public class TaskNotFoundException extends Exception{
	
	public TaskNotFoundException() {
		
	}
	public TaskNotFoundException(String msg) {
		super(msg);
	}

}
