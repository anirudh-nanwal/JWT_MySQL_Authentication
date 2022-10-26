package com.user.auth.jwt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.auth.jwt.dao.RoleDao;
import com.user.auth.jwt.dao.UserDao;
import com.user.auth.jwt.entity.Role;
import com.user.auth.jwt.entity.User;

/**
 * @author anirudh.nanwal
 * Service for User related calls.
 */

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private  PasswordEncoder passwordEncoder;

	public User addUser(User newUser) {
		return userDao.save(newUser);
	}

	public void initRolesAndUsers() {
		Role adminRole = new Role("Admin", "Admin Role");
		Role userRole = new Role("User", "Default role for newly created User");
		roleDao.save(adminRole);
		roleDao.save(userRole);
		Set<Role> adminRoles = new HashSet<Role>();
		adminRoles.add(adminRole);
		Set<Role> userRoles = new HashSet<Role>();
		userRoles.add(userRole);
		User adminUser = new User("nano", "Anirudh", "Nanwal", getEncodedPassword("asdf"), adminRoles);
		User user = new User("nano1", "Anirudh1", "Nanwal1", getEncodedPassword("asdf1"), userRoles);
		userDao.save(adminUser);
		userDao.save(user);
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
