package com.TodoCRUD.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

   @Entity
	
	public class Task {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  private String title;

	  private String description;

	  private boolean completed;

	  // Constructors
	  public Task() {}

	  public Task(String title, String description, boolean completed) {
	    this.title = title;
	    this.description = description;
	    this.completed = completed;
	  }

	  // Getters and setters

	  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public String getTitle() {
	    return title;
	  }

	  public void setTitle(String title) {
	    this.title = title;
	  }

	  public String getDescription() {
	    return description;
	  }

	  public void setDescription(String description) {
	    this.description = description;
	  }

	  public boolean isCompleted() {
	    return completed;
	  }

	  public void setCompleted(boolean completed) {
	    this.completed = completed;
	  }

}
