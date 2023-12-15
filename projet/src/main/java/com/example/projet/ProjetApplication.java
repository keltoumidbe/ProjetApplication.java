package com.example.projet;

import com.example.projet.Entities.Role;
import com.example.projet.Entities.User;
import com.example.projet.Services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}
	@Autowired
	UserService userService;
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	//@PostConstruct
void init_users(){
userService.addRole(new Role(null,"ADMIN"));
userService.addRole(new Role(null,"USER"));
userService.addRole(new Role(null,"CREATE"));

    userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"enseignant","123",true,null));
	userService.saveUser(new User(null,"etudiant","123",true,null));

	userService.addRoleToUser("admin","ADMIN");
	userService.addRoleToUser("admin","CREATE");
	userService.addRoleToUser("enseignant","CREATE");
	userService.addRoleToUser("admin","ADMIN");
	userService.addRoleToUser("etudiant","USER");

	}

}


