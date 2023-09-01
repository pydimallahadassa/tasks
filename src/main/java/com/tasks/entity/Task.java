package com.tasks.entity;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
	
	@Id
	@GeneratedValue
	private int taskId;
	@NotEmpty(message = "Name may not be empty")
	private String taskName;
	private long employeeId;
	@JsonFormat(pattern="HH:mm")
	private LocalTime timeDuration;
	private String comment;
	
	@Transient
	private Employee employee;

}
