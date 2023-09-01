package com.tasks.exception;

@SuppressWarnings("serial")
public class TaskExistsException extends Exception{
	
	public TaskExistsException() {
		
	}
	public TaskExistsException(String msg) {
		super(msg);
	}


}
