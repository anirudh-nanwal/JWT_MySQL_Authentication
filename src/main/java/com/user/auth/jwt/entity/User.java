/**
 * 
 */
package com.user.auth.jwt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author anirudh.nanwal 
 * Entity for User.
 */
@Entity
public class User {

	@Id
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<Role> roles;
	/**
	 * Parameterized constructor with userName.
	 * @param userName
	 * @param userFirstName
	 * @param userLastName
	 * @param userPassword
	 * @param roles
	 */
	public User(String userName, String userFirstName, String userLastName, String userPassword,
			Set<Role> roles) {
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPassword = userPassword;
		this.roles = roles;
	}
	/**
	 * Default constructor.
	 */
	public User() {
	}
	/**
	 * To get the userName.
	 * 
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * To get the userFirstName.
	 * 
	 * @return the userFirstName
	 */
	public String getUserFirstName() {
		return userFirstName;
	}
	/**
	 * To get the userLastName.
	 * 
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}
	/**
	 * To get the encrypted userPassword.
	 * 
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * To get the userRoles.
	 * 
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}
	/**
	 * To set the userName.
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * To set the userFirstName.
	 * 
	 * @param userFirstName
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	/**
	 * To set the userLastName.
	 * 
	 * @param userLastName
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	/**
	 * To set the userPassword.
	 * 
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * To set the userRoles.
	 * 
	 * @param roles
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	/**
	 * Overridden toString method.
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userPassword=" + userPassword + ", roles=" + roles + "]";
	}

	
}
