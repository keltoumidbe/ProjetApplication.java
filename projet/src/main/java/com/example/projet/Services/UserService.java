package com.example.projet.Services;

import com.example.projet.Entities.Role;
import com.example.projet.Entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username,String rolename);
    List<User> findAllUser();
}
