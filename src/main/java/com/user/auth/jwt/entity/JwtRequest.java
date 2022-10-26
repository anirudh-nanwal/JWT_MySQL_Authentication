/**
 * 
 */
package com.user.auth.jwt.entity;

/**
 * @author anirudh.nanwal
 *
 */
public class JwtRequest {

	private String userName;
	private String userPassword;
	/**
	 * To get the userName.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * To get the userPassword.
	 *
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
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
	 * To set the userPassword.
	 *
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
