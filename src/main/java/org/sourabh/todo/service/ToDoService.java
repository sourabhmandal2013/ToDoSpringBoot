package org.sourabh.todo.service;

import java.util.List;

import org.sourabh.todo.dto.TodoDTO;
import org.sourabh.todo.entity.Todo;


public interface ToDoService {
	
	public boolean addToDoEntry(TodoDTO todoDTO);
	
	public Todo removeTodo(String id);
	
	public List<Todo> showAllTodo();
	
	public Todo getTodo(String id);
	
	public List<Todo> getAllTodoByUserId(String userId);
	
}
