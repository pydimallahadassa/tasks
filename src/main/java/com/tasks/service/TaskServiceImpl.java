package com.tasks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tasks.entity.Employee;
import com.tasks.entity.Task;
import com.tasks.exception.TaskExistsException;
import com.tasks.exception.TaskNotFoundException;
import com.tasks.repository.ITaskRepository;

@Service
public class TaskServiceImpl implements ITaskService {
	
	@Autowired
	ITaskRepository taskRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TaskServiceImpl(ITaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}
	
	TaskNotFoundException ex = new TaskNotFoundException("Task not found with id: ");
	
	@Override
	public Task addTask(Task task) throws TaskExistsException {
		Optional<Task> t1 = taskRepo.findByTaskName(task.getTaskName());
		if(t1.isPresent()) {
			throw new TaskExistsException("Task already exists with name: "+task.getTaskName());
		} else {
			return taskRepo.save(task);
		}
	}

	@Override
	public Task updateTask(int taskId, Task task) throws TaskNotFoundException {
		Optional<Task> t1 = taskRepo.findById(taskId);
		if(t1.isPresent()) {
			Task updatedTask = t1.get();
			updatedTask.setTaskName(task.getTaskName());
			updatedTask.setEmployeeId(task.getEmployeeId());
			updatedTask.setTimeDuration(task.getTimeDuration());
			updatedTask.setComment(task.getComment());
			taskRepo.save(updatedTask);
			return updatedTask;
		} else {
			throw ex;
		}
	}

	@Override
	public Task deleteTask(int taskId) throws TaskNotFoundException {
		Optional<Task> taskOpt = taskRepo.findById(taskId);
		if(taskOpt.isPresent()) {
			Task t1 = taskOpt.get();
			taskRepo.deleteById(taskId);
			return t1;
		}else {
			throw ex;
		}
	}

	@Override
	public Task getTaskById(int taskId) throws TaskNotFoundException {
		Optional<Task> t1=taskRepo.findById(taskId);
		if(t1.isPresent()) {
			return t1.get();
		}else {
			throw ex;
		}
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

	@Override
	public Task getByEmpId(long employeeId) {
		Task task = taskRepo.findByEmployeeId(employeeId);
		Employee emp = restTemplate.getForObject("http://localhost:9090/employee/get/"+task.getEmployeeId(), Employee.class);
		task.setEmployee(emp);
		return task;
	}

}
