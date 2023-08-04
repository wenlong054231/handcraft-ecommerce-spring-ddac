package com.DDAC.SpringAngular.DTO;

public class UserSaveDTO {
	
	private int userid;
	private String username;
	private String password;
	
	public UserSaveDTO(String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
	}

	public UserSaveDTO() {
		super();
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	
}
