/**
 * 
 */
package com.user.auth.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.auth.jwt.dao.RoleDao;
import com.user.auth.jwt.entity.Role;

/**
 * @author anirudh.nanwal
 * Service for Role related calls.
 *
 */
@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;

	public Role addRole(Role newRole) {
		return roleDao.save(newRole);
	}
}
