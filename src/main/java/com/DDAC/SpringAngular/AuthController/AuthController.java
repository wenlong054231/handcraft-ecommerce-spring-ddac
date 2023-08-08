package com.DDAC.SpringAngular.AuthController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DDAC.SpringAngular.DTO.UserDTO;
import com.DDAC.SpringAngular.DTO.UserSaveDTO;
import com.DDAC.SpringAngular.DTO.UserUpdateDTO;
import com.DDAC.SpringAngular.Service.UserService;
import com.DDAC.SpringAngular.entities.User;

@RestController

@RequestMapping("api/v1/user")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin(origins = "http://localhost:5173/") 
	@PostMapping(path = "/save")
	public ResponseEntity<String> saveUser(@RequestBody UserSaveDTO userSaveDTO) {
		
		ResponseEntity<String> id = userService.addUser(userSaveDTO);
		return id;
	}
	
	@CrossOrigin(origins = "*") 
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") int id) {
		User user = userService.getUserById(id);
		return user;
	}
	
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
	        // Validate login credentials and return appropriate response
	        if (isValidLogin(loginRequest.getUsername(), loginRequest.getPassword())) {
	            return ResponseEntity.ok("{\"success\": true}");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false}");
	        }
	    }
	 
	private boolean isValidLogin(String username, String password) {
		
		User user = userService.findByUsername(username);
	
		 if (user != null && user.getPassword().equals(password)) {
	            return true;
	        }
		
		return false;
	}

	@PostMapping(path = "/update")
	public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
		
		String id = userService.updateUser(userUpdateDTO);
		return id;
	}
	
	@DeleteMapping(path = "/deleteuser/{id}")
	public String deleteUser(@PathVariable(value = "id") int id) {
		
		boolean deleteuser = userService.deleteUser(id);
		return "deleted";
	}

}
