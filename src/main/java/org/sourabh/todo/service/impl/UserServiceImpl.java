package org.sourabh.todo.service.impl;

import java.util.List;

import org.sourabh.todo.dto.LoginDTO;
import org.sourabh.todo.entity.User;
import org.sourabh.todo.repository.UserRepository;
import org.sourabh.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean addUser(User user) {
		boolean sucess = false;
		try {
			userRepository.save(user);
			sucess = true;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return sucess;
	}

	@Override
	public User removeUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> showAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean loginUser(LoginDTO loginDTO) {
		
		boolean access = false;
		User userItem = new User();
		try {
			userItem = userRepository.findByUserEmail(loginDTO.getEmailId());
			if(userItem.getUserPassword().equals(loginDTO.getPassword()))
				access = true;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return access;
	}

}
