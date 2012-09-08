package net.grosso.me.domain;

import java.io.Serializable;

public class UserRole implements Serializable {

	private static final long serialVersionUID = 4871234049403929555L;
	private Integer userId;
	private String userName;
	private Integer roleId;
	private String roleName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
