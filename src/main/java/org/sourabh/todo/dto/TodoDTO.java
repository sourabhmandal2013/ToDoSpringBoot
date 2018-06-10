package org.sourabh.todo.dto;

public class TodoDTO {

	private String name;
	
	private String description;
		
	private Boolean reminder;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getReminder() {
		return reminder;
	}

	public void setReminder(Boolean reminder) {
		this.reminder = reminder;
	}

}
