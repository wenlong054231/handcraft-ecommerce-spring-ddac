package com.DDAC.SpringAngular.AuthController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DDAC.SpringAngular.DTO.UserDTO;
import com.DDAC.SpringAngular.Service.UserService;
import com.DDAC.SpringAngular.entities.User;

@RestController
@CrossOrigin
@RequestMapping("api/v1/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/save")
	public String saveUser(@RequestBody UserDTO userDTO) {
		
		String id = userService.addUser(userDTO);
		return id;
	}
	
}
