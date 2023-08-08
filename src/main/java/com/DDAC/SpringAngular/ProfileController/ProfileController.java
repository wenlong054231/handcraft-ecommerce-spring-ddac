package com.DDAC.SpringAngular.ProfileController;

import com.DDAC.SpringAngular.entities.User;
import com.DDAC.SpringAngular.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/v1/profile")
    public User getUserProfile(@RequestParam String username) {
        return userService.findByUsername(username);
    }
}