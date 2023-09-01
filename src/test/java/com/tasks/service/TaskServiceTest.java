package com.tasks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tasks.entity.Task;
import com.tasks.exception.TaskExistsException;
import com.tasks.exception.TaskNotFoundException;

@SpringBootTest
class TaskServiceTest {
	
	@Autowired
	ITaskService taskService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
	}
	
	@Test
	void addTaskTest()throws TaskExistsException{
		Task t1 = new Task();
		t1.setTaskName("Docker");
		Task newTask= taskService.addTask(t1);
		assertEquals("Docker", newTask.getTaskName());
	}
	
	@Test
	void deleteTaskTest() throws TaskNotFoundException {
		Task t1 = taskService.deleteTask(402);
		assertEquals("Jenkins", t1.getTaskName());
	}
	
	@Test
	void getAllTaskTest() {
		List<Task> tasks = taskService.getAllTasks();
		assertEquals(5, tasks.size());
		
	}

}
