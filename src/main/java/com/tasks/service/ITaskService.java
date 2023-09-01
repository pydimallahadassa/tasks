package com.tasks.service;

import java.util.List;

import com.tasks.entity.Task;
import com.tasks.exception.TaskExistsException;
import com.tasks.exception.TaskNotFoundException;

public interface ITaskService {
	
	Task addTask(Task task) throws TaskExistsException;
	Task updateTask(int taskId, Task task) throws TaskNotFoundException;
	Task deleteTask(int taskId) throws TaskNotFoundException;
	Task getTaskById(int taskId) throws TaskNotFoundException;
	List<Task> getAllTasks();
	//Task getTaskByEmp(String emp) throws TaskNotFoundException;
	Task getByEmpId(long employeeId);
	

}
