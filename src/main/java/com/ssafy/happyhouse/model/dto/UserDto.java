package com.ssafy.happyhouse.model.dto;

public class UserDto {
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String addr;
	private String phone;
	
	public UserDto() {
		super();
		
	}
	
	public UserDto(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public UserDto(String userId, String userPwd, String userName, String email, String addr, String phone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.addr = addr;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ ", addr=" + addr + ", phone=" + phone + "]";
	}
	
	
	
	
	
	
}
