package org.sourabh.todo.repository;

import javax.transaction.Transactional;

import org.sourabh.todo.entity.User;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserEmail(String email);
}
