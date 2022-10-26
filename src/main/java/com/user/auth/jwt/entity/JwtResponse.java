/**
 * 
 */
package com.user.auth.jwt.entity;

/**
 * @author anirudh.nanwal
 *
 */
public class JwtResponse {

	private User user;
	private String jwtToken;
	/**
	 * To get the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * To get the jwtToken.
	 *
	 * @return the jwtToken
	 */
	public String getJwtToken() {
		return jwtToken;
	}
	/**
	 * To set the user.
	 *
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * To set the jwtToken.
	 *
	 * @param jwtToken
	 */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	/**
	 * Parameterized Constructor for JwtResponse.
	 * 
	 * @param user
	 * @param jwtToken
	 */
	public JwtResponse(User user, String jwtToken) {
		this.user = user;
		this.jwtToken = jwtToken;
	}
	/**
	 * Default Constructor for JwtResponse.
	 */
	public JwtResponse() {
	}
	
}
