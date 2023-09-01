package com.tasks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasks.entity.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {

	//Optional<Task> findByAllocatedEmp(String allocatedEmp);

	Optional<Task> findByTaskName(String taskName);

	Task findByEmployeeId(long employeeId);

}
