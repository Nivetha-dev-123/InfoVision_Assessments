package com.TodoCRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TodoCRUD.Entity.Task;
import com.TodoCRUD.Service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	 @Autowired
	  private TaskService taskService;

	  @GetMapping
	  public List<Task> getAllTasks() {
	    return taskService.getAllTasks();
	  }

	  @GetMapping("/{id}")
	  public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
	    return taskService.getTaskById(id)
	      .map(ResponseEntity::ok)
	      .orElse(ResponseEntity.notFound().build());
	  }

	  @PostMapping
	  public Task createTask(@RequestBody Task task) {
	    return taskService.createTask(task);
	  }

	  @PutMapping("/{id}")
	  public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
	    Task updated = taskService.updateTask(id, task);
	    return ResponseEntity.ok(updated);
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
	    taskService.deleteTask(id);
	    return ResponseEntity.noContent().build();
	  }

}
