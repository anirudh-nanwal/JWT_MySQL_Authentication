/**
 * 
 */
package com.user.auth.jwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.auth.jwt.entity.Role;

/**
 * @author anirudh.nanwal
 * DAO for Role related calls.
 *
 */
@Repository
public interface RoleDao extends CrudRepository<Role, String>{

}
