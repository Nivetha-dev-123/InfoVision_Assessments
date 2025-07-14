package com.TodoCRUD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TodoCRUD.Entity.Task;
import com.TodoCRUD.Resporitory.TaskRepository;

@Service
public class TaskService {
	
	 @Autowired
	  private TaskRepository taskRepository;

	  public List<Task> getAllTasks() {
	    return taskRepository.findAll();
	  }

	  public Optional<Task> getTaskById(Long id) {
	    return taskRepository.findById(id);
	  }

	  public Task createTask(Task task) {
	    return taskRepository.save(task);
	  }

	  public Task updateTask(Long id, Task updatedTask) {
	    return taskRepository.findById(id)
	      .map(task -> {
	        task.setTitle(updatedTask.getTitle());
	        task.setDescription(updatedTask.getDescription());
	        task.setCompleted(updatedTask.isCompleted());
	        return taskRepository.save(task);
	      })
	      .orElseGet(() -> {
	        updatedTask.setId(id);
	        return taskRepository.save(updatedTask);
	      });
	  }

	  public void deleteTask(Long id) {
	    taskRepository.deleteById(id);
	  }
	

}
