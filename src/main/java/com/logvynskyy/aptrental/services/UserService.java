package com.logvynskyy.aptrental.services;

import com.logvynskyy.aptrental.entities.User;
import com.logvynskyy.aptrental.dao.UserDAO;
import com.logvynskyy.aptrental.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserDAO userRepository;

//    @Autowired
//    private WebSecurityConfig webSecurityConfig;
//
//    @PostConstruct
//    public void init() {
//        webSecurityConfig.setUserService(this);
//    }

//    BCryptPasswordEncoder bCryptPasswordEncoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

//    public void setBCrypt(BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(int userId) {
        Optional<User> userFromDb = userRepository.getUserByID(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.getAllUsers();
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.getUserByName(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.addUser(user);
        return true;
    }
}
