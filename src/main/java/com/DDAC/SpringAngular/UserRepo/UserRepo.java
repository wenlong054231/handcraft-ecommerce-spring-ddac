package com.DDAC.SpringAngular.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.DDAC.SpringAngular.entities.User;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);
	
}
