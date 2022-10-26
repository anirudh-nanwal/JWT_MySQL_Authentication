/**
 * 
 */
package com.user.auth.jwt.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.auth.jwt.entity.Role;
import com.user.auth.jwt.entity.User;
import com.user.auth.jwt.service.UserService;

/**
 * @author anirudh.nanwal
 * Controller for User related calls.
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUsers();
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User newUser) {
		Set<Role> userRoles = newUser.getRoles();
		if(userRoles == null || userRoles.isEmpty()) {
			userRoles = new HashSet<Role>();
			userRoles.add(new Role("User", "Default role for newly created User"));
			newUser.setRoles(userRoles);
		}
		return userService.addUser(newUser);
	}
	
	@GetMapping("/forAdmin")
	public String forAdmin() {
		return "Getmapping for admin";
	}
	
	@GetMapping("/forUser")
	public String forUser() {
		return "Getmapping for user";
	}
}
