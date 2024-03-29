/* package com.example.projet.Security;

import com.example.projet.Entities.User;
import com.example.projet.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.findUserByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("User not found");
        else {
            List<GrantedAuthority> authorities=new ArrayList<>();
            user.getRoles().forEach(role -> {
                GrantedAuthority authority=new SimpleGrantedAuthority(role.getRole());
                authorities.add(authority);
            });
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),authorities);
        }


    }
}
*/