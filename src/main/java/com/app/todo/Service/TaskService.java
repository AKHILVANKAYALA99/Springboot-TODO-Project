package com.app.todo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todo.Model.Task;
import com.app.todo.Repository.TodoRepository;

@Service
public class TaskService {

	@Autowired
	TodoRepository taskRepository;
	
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public void createTask(String name) {
		Task task = new Task();
		task.setCompleted(false);
		task.setName(name);
		taskRepository.save(task);
	}


	public void deleteService(Integer id) {
		taskRepository.deleteById(id);
	}

	public void toggleTask(Integer id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(!task.isCompleted()); 
        taskRepository.save(task); 
	}
	
	
	
	

}
