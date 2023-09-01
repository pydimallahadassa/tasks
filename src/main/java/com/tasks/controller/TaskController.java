package com.tasks.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.tasks.entity.Employee;
import com.tasks.entity.Task;
import com.tasks.exception.TaskExistsException;
import com.tasks.exception.TaskNotFoundException;
import com.tasks.service.TaskServiceImpl;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins="http://localhost:4200")
public class TaskController {
	
	@Autowired
	TaskServiceImpl taskServ;
	
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/add")
	ResponseEntity<Task> addTask(@RequestBody Task task) throws TaskExistsException{
		logger.info("Sending request to add new task");
		Task newTask = taskServ.addTask(task);
		logger.info("Added new task");
		return new ResponseEntity<>(newTask, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{taskId}")
	ResponseEntity<Task> updateTask(@PathVariable int taskId,@RequestBody Task task) throws TaskNotFoundException{
		logger.info("Request to update existing task");
		Task updatedTask = taskServ.updateTask(taskId, task);
		logger.info("Successfully updated existing task");
		return new ResponseEntity<>(updatedTask, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{taskId}")
	ResponseEntity<Task> deleteTask(@PathVariable int taskId) throws TaskNotFoundException{
		logger.info("Request to delete a task");
		Task deletedTask = taskServ.deleteTask(taskId);
		logger.info("Successfully deleted a task");
		return new ResponseEntity<>(deletedTask,HttpStatus.OK);
	}
	
	@GetMapping("/get/{taskId}")
	ResponseEntity<Task> getTaskById(@PathVariable int taskId) throws TaskNotFoundException{
		logger.info("Request to view a task by taskId");
		Task task = taskServ.getTaskById(taskId);
		logger.info("Successfully viewed a task by taskId");
		return new ResponseEntity<>(task,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<Task>> getAllTasks(){
		logger.info("Request to view all tasks");
		List<Task> tasks = taskServ.getAllTasks();
		logger.info("Successfully viewed all tasks");
		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}
	
//	@GetMapping("/getByName/{allocatedEmp}")
//	ResponseEntity<Task> getTaskByEmp(@PathVariable String allocatedEmp) throws TaskNotFoundException{
//		logger.info("Request to view a task by taskname");
//		Task task = taskServ.getTaskByEmp(allocatedEmp);
//		logger.info("Successfully viewed a task by taskname");
//		return new ResponseEntity<>(task,HttpStatus.OK);
//	}
	
	@GetMapping("/getByEmpId/{employeeId}")
	ResponseEntity<Task> getByEmpId(@PathVariable long employeeId){
		logger.info("Request to view a task by empId");
		Task task = taskServ.getByEmpId(employeeId);
		logger.info("Successfully viewed a task by empId");
		return new ResponseEntity<>(task,HttpStatus.OK);
	}
	
	
	
	

}
