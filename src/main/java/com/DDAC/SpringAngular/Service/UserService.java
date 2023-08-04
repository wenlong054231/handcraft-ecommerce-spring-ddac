package com.DDAC.SpringAngular.Service;

import com.DDAC.SpringAngular.DTO.UserDTO;
import com.DDAC.SpringAngular.DTO.UserSaveDTO;

public interface UserService {

	String addUser(UserSaveDTO userSaveDTO);

	String addUser(UserDTO userDTO);

}
