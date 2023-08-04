package com.DDAC.SpringAngular.DTO;

public class UserSaveDTO {
	
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
		return "UserDTO [username=" + username + ", password=" + password + "]";
	}
	
}
