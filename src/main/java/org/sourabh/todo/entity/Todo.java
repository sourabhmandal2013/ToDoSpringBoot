package org.sourabh.todo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String name;
	
	private String description;
	
	@NotNull
	private Date created;
	
	@NotNull
	private Date updated;
	
	private Boolean reminder;
	
	private Boolean completed;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getReminder() {
		return reminder;
	}

	public void setReminder(Boolean reminder) {
		this.reminder = reminder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Todo(String name, String description, Date created, Date updated, Boolean reminder, User user) {
		super();
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.reminder = reminder;
		this.user = user;
	}

	public Todo() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	
	

}
