package com.kandagar.rls.model;

import com.kandagar.rls.model.RoleModel;

public class UserModel extends BaseModel {

private String name;

	private String additionalInformation;
	
	private String login;
	
	private String password;
	
	private String oldPassword;

	private String email;
	
	private boolean isActive;
		
    private RoleModel role;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isactive) {
		this.isActive = isactive;
	}
}
