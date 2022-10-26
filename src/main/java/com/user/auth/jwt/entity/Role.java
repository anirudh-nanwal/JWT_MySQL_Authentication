/**
 * 
 */
package com.user.auth.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author anirudh.nanwal 
 * Entity for Role.
 */
@Entity
public class Role {

	@Id
	private String roleName;
	private String roleDescription;

	/**
	 * Default constructor.
	 */
	public Role() {
	}

	/**
	 * Parameterized constructor with roleName.
	 * 
	 * @param roleName
	 * @param roleDescription
	 */
	public Role(String roleName, String roleDescription) {
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}


	/**
	 * To get the roleName.
	 * 
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * To get the roleDescription.
	 * 
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}


	/**
	 * To set the roleName.
	 * 
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * To set the roleDescription
	 * 
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	/**
	 * Overridden toString method.
	 */
	@Override
	public String toString() {
		return "Role [roleName=" + roleName + ", roleDescription=" + roleDescription + "]";
	}
}
