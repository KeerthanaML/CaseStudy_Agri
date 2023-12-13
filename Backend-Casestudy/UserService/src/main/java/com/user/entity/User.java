package com.user.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;




@Document(collection="UserA")
public class User {
	@Id
	private String userid= UUID.randomUUID().toString();
	 @NotBlank(message = "Username cannot be blank")
	private String uName;
	 @NotBlank(message = "Email cannot be blank")
	 @Email(message = "Invalid email format")
	private String uEmail;
	private String uPassword;
	private Address address;
	@Pattern(regexp = "^[0-9]*$", message = "Mobile number must contain only digits")
	private String uMobile;
	private String uRole;
	
	
	
	
	

	public User(String userid, String uName,String uEmail,String uPassword, Address address, String uMobile,String uRole) {
		super();
		this.userid = userid;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.address = address;
		this.uMobile = uMobile;
		this.uRole = uRole;
	}


	public User() {
		super();
	}
	
	
//	public boolean isLoggedIn() {
//		return isLoggedIn;
//	}
//	public void setLoggedIn(boolean isLoggedIn) {
//		this.isLoggedIn = isLoggedIn;
//	}
	
	
	
	public String getuName() {
		return uName;
	}
	



	
	


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getuMobile() {
		return uMobile;
	}
	public void setuMobile(String uMobile) {
		this.uMobile = uMobile;
	}
	public String getuRole() {
		return uRole;
	}
	public void setuRole(String uRole) {
		this.uRole = uRole;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", uName=" + uName + ", uEmail=" + uEmail + ", uPassword=" + uPassword
				+ ", address=" + address + ", uMobile=" + uMobile + ", uRole=" + uRole + "]";
	}

	
	
	
	
	
	
	
	
}
