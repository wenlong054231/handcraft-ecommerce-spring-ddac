package com.DDAC.SpringAngular.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.DDAC.SpringAngular.DTO.UserDTO;
import com.DDAC.SpringAngular.DTO.UserSaveDTO;
import com.DDAC.SpringAngular.UserRepo.UserRepo;
import com.DDAC.SpringAngular.entities.User;

public class UserServiceIMPL implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public String addUser(UserSaveDTO userSaveDTO) {
		// TODO Auto-generated method stub
		
		User user = new User(
			userSaveDTO.getUsername(),
			userSaveDTO.getPassword()
		);
		return user.getUsername();
	
	}

	
	
}
