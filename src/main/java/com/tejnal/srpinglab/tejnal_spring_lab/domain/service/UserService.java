package com.tejnal.srpinglab.tejnal_spring_lab.domain.service;

import com.tejnal.srpinglab.tejnal_spring_lab.domain.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    User findOne(int id);

    User deleteById(int id);




}
