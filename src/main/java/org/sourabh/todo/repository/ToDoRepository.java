package org.sourabh.todo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.sourabh.todo.entity.Todo;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ToDoRepository extends CrudRepository<Todo, Integer>{
	
	public List<Todo> findByUserUserId(Integer id);
}
