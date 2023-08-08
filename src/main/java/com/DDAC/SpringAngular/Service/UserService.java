package com.DDAC.SpringAngular.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DDAC.SpringAngular.DTO.UserDTO;
import com.DDAC.SpringAngular.DTO.UserSaveDTO;
import com.DDAC.SpringAngular.DTO.UserUpdateDTO;
import com.DDAC.SpringAngular.entities.User;
 
@Service
public interface UserService {
	
	@Transactional
	ResponseEntity<String> addUser(UserSaveDTO userSaveDTO);

	String addUser(UserDTO userDTO);

	String updateUser(UserUpdateDTO userUpdateDTO);

	boolean deleteUser(int id);

	User getUserById(int id);

	User findByUsername(String username);

}
