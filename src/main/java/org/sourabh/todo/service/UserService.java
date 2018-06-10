package org.sourabh.todo.service;

import java.util.List;

import org.sourabh.todo.dto.LoginDTO;
import org.sourabh.todo.entity.User;

public interface UserService {
	
	public boolean loginUser(LoginDTO loginDTO);
	
	public boolean addUser(User user);
	
	public User removeUser(String id);
	
	public List<User> showAllUser();
	
	public User getUser(String id);
	
}
