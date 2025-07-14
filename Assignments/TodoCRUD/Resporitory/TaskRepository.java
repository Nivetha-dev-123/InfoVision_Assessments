package com.TodoCRUD.Resporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TodoCRUD.Entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
