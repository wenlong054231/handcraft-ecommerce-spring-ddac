package com.DDAC.SpringAngular.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DDAC.SpringAngular.DTO.UserDTO;
import com.DDAC.SpringAngular.DTO.UserSaveDTO;
import com.DDAC.SpringAngular.DTO.UserUpdateDTO;
import com.DDAC.SpringAngular.UserRepo.UserRepo;
import com.DDAC.SpringAngular.entities.User;

@Service
public class UserServiceIMPL implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	@Qualifier("userService")
	  public ResponseEntity<String> addUser(UserSaveDTO userSaveDTO) {
        try {
        	
        	if (userRepo.existsByUsername(userSaveDTO.getUsername())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"success\": false, \"message\": \"Username already exists.\"}");
            }
        	
        	if (userRepo.existsByEmail(userSaveDTO.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"success\": false, \"message\": \"Email already exists.\"}");
            }
        	
            User user = new User(
                userSaveDTO.getFirstname(),
                userSaveDTO.getLastname(),
                userSaveDTO.getUsername(),
                userSaveDTO.getPassword(),
                userSaveDTO.getEmail()
            );

            userRepo.save(user);
            
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"success\": true}");
        } catch (Exception e) {
            // Handle any exception that occurs during user creation
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"success\": false}");
        }
    }

	@Override
	public String addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(UserUpdateDTO userUpdateDTO) {
		// TODO Auto-generated method stub
		
		if(userRepo.existsById(userUpdateDTO.getUserid())) {
			
			User user = userRepo.getById(userUpdateDTO.getUserid());
			
			user.setUsername(userUpdateDTO.getUsername());
			user.setPassword(userUpdateDTO.getPassword());
			userRepo.save(user);
		}else {
			System.out.print("User ID do not exists.");
		}
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		
		if(userRepo.existsById(id)) {
			
			userRepo.deleteById(id);
			
		}else {
			System.out.println("User id not found.");
		}
		
		return false;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
