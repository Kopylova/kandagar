package com.kandagar.rls.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User extends BaseEntity {

	@NotEmpty
	@Size(max=50)
	@Column(nullable=false, length=50)
	private String name;
	
	@Column(name="additional_information", length=1000)
	private String additionalInformation;
	
	@NotEmpty
	@Size(max=50)
	@Column(nullable=false, length=50)
	private String login;
	
	@Size(max=50)
	//@Pattern(regexp="^(?=.{6,})(?=.*[A-ZÀ-ß])(?=.*[a-zà-ÿ])(?=.*[0-9])(?=.*\\W).*$")
	@Column(nullable=false, length=100)
	private String password;

	@NotEmpty
	@Size(max=50)
	@Email
	@Column(nullable=false, length=50)
	private String email;
	
	@Column(name="active", nullable=false, columnDefinition="BIT", length=1)
	private boolean isActive;
		
	@ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isactive) {
		this.isActive = isactive;
	}
}
