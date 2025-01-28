package com.app.todo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.todo.Model.Task;
import com.app.todo.Service.TaskService;



@Controller
@RequestMapping("tasks")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@GetMapping("/alltasks")
	public String getTasks(Model model) {
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		return "tasks";
	}
	
	@PostMapping("/create")
	public String createTask(@RequestParam String name) {
		taskService.createTask(name);
		return "redirect:/tasks/alltasks";
	}
	
	@GetMapping("/create")
	public String handleGetOnCreate() {
	    return "redirect:/tasks/alltasks";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Integer id) {
	    taskService.deleteService(id);
	    return "redirect:/tasks/alltasks";
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Integer id) {
	    taskService.toggleTask(id);
	    return "redirect:/tasks/alltasks";
	}
	
	
	
	
	
	
	 
}
