package com.logvynskyy.aptrental.dao;

import com.logvynskyy.aptrental.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<User> getUserByID(int id){
        String sql = "SELECT * FROM USERS WHERE ID = " + id;

        List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));

        return Optional.ofNullable(users.get(0));
//        return usersList.stream().filter(user -> user.getId() == id).findAny();
    }

    public User getUserByName(String name){
        String sql = "SELECT * FROM USERS WHERE NAME = " + name;

        List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));

        return users.get(0);
//        return usersList.stream().filter(apartment -> apartment.getName().equals(name)).findAny().orElse(null);
    }

    public void addUser(User user){
//        user.setId(counter++);
//        usersList.add(user);
        String sql = "INSERT INTO USERS(NAME, PASSWORD, PHONE_NUMBER) values (?, ?, ?)";

        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getPhoneNumber());
    }

    public List<User> getAllUsers(){
        String sql = "SELECT * FROM USERS";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
    }
}
