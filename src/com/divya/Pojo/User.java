package com.divya.Pojo;

import org.apache.struts.action.ActionForm;

public class User extends ActionForm {

	private String userName;
	private String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
