package com.kandagar.rls.model;

import java.util.Set;

import com.kandagar.rls.model.UserModel;

public class RoleModel extends BaseModel {

	private String name;

	private Set<UserModel> users;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserModel> getUsers() {
		return users;
	}

	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}
	
}
