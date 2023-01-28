package com.example.springboot.repository;

import com.example.springboot.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User readUser(int id);
}
