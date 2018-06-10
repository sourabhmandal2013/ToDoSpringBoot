package org.sourabh.todo.api;

import org.sourabh.todo.dto.LoginDTO;
import org.sourabh.todo.entity.User;
import org.sourabh.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UsersManagement {

	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(
			@RequestBody LoginDTO loginDTO
			){
		boolean flag = false;
		try {
				flag = userService.loginUser(loginDTO);
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		return "Access : " + flag;
	}
	
	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public String signUp(
			@RequestBody LoginDTO loginDTO
			){
		boolean flag = false;
		try {
				User user = new User();
				user.setUserEmail(loginDTO.getEmailId());
				user.setUserPassword(loginDTO.getPassword());
				flag = userService.addUser(user);
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		return "User Added : " + flag;
	}
	
}
