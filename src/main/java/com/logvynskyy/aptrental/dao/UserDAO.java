package com.logvynskyy.aptrental.dao;

import com.logvynskyy.aptrental.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO implements UserDetailsService {
    private List<User> usersList = new ArrayList<>();
    private static int counter = 0;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUserByID(int id){
        return usersList.stream().filter(apartment -> apartment.getId() == id).findAny().orElse(null);
    }

    public User getUserByName(String name){
        return usersList.stream().filter(apartment -> apartment.getName().equals(name)).findAny().orElse(null);
    }

    public void addUser(User user){
        user.setId(counter++);
        usersList.add(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByName(username);

        if (user == null) { 
            throw new UsernameNotFoundException("User not found");
        }

        return null;
    }
}
