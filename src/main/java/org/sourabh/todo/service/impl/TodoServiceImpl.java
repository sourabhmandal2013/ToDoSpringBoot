package org.sourabh.todo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sourabh.todo.dto.TodoDTO;
import org.sourabh.todo.entity.Todo;
import org.sourabh.todo.entity.User;
import org.sourabh.todo.repository.ToDoRepository;
import org.sourabh.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements ToDoService {

	@Autowired 
	ToDoRepository todoRepository;
	
	@Override
	public boolean addToDoEntry(TodoDTO todoDTO) {
		
		boolean done = false;
		try {
			User user = null;
			Todo todoToSave = new Todo(todoDTO.getName(),todoDTO.getDescription(),new Date(),new Date(),todoDTO.getReminder(), user);
			todoRepository.save(todoToSave);
			done = true;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return done;
	}

	@Override
	public Todo removeTodo(String id) {
		
		Todo todoItem = new Todo();
		try {
			todoItem = todoRepository.findById(Integer.valueOf(id)).get();
			if(todoItem == null)
			{
				System.out.println("Item Does Not Exists");
			}
			else {
				todoRepository.delete(todoItem);
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return todoItem;
	}

	@Override
	public List<Todo> showAllTodo() {
		List <Todo> todoList = new ArrayList<Todo>();
		try {
			for (Todo todo : todoRepository.findAll()) {
				todoList.add(todo);
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return todoList;
	}

	@Override
	public Todo getTodo(String id) {
		
		Todo todoItem = new Todo();
		try {
			todoItem = todoRepository.findById(Integer.valueOf(id)).get();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return todoItem;
	}

	@Override
	public List<Todo> getAllTodoByUserId(String userId) {
		List<Todo> todoList = new ArrayList<Todo>();
		try {
			for (Todo todo : todoRepository.findByUserUserId(Integer.valueOf(userId))) {
				todoList.add(todo);
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return todoList;
	}

	
}
