/**
 * 
 */
package com.user.auth.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.auth.jwt.entity.Role;
import com.user.auth.jwt.service.RoleService;

/**
 * @author anirudh.nanwal
 * Controller for Role related calls.
 *
 */
@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/role")
	public Role addRole(@RequestBody Role newRole) {
		return roleService.addRole(newRole);
	}
}
