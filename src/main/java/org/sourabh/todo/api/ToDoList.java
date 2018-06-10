package org.sourabh.todo.api;

import java.util.ArrayList;
import java.util.List;

import org.sourabh.todo.dto.TodoDTO;
import org.sourabh.todo.entity.Todo;
import org.sourabh.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/todo")
public class ToDoList {
	
	@Autowired
	ToDoService toDoService;
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Todo getTodoWithId(@PathVariable (name = "id") final String id){
		Todo todoItem = new Todo();
		try{
			todoItem = toDoService.getTodo(id);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		};
		return todoItem;
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public boolean addTodo(
			@RequestBody TodoDTO todoDTO
			){
		
		boolean success = false;
		
		try{
			success = toDoService.addToDoEntry(todoDTO);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		};
		return success;
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public Todo deleteTodoWithId(@PathVariable (name = "id") final String id){
		Todo todo = new Todo();
		try{
			todo = toDoService.removeTodo(id);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		};
		return todo;
	}
	@RequestMapping(path = "/all/{userId}", method = RequestMethod.DELETE)
	public List<Todo> allTodoWithUserId(@PathVariable (name = "userId") final String userId){
		List<Todo> todoListForUser = new ArrayList<Todo>();
		try{
			todoListForUser = toDoService.getAllTodoByUserId(userId);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		};
		return todoListForUser;
	}
	
	
}
