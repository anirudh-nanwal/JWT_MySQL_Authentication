/**
 * 
 */
package com.user.auth.jwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.auth.jwt.entity.User;

/**
 * @author anirudh.nanwal
 * DAO for User related calls.
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, String> {

}
