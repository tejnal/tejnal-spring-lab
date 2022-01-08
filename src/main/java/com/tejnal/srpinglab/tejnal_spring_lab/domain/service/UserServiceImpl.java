package com.tejnal.srpinglab.tejnal_spring_lab.domain.service;


import com.tejnal.srpinglab.tejnal_spring_lab.domain.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserServiceImpl implements UserService {

    // arrayList contains duplicate elements
    // ArrayList class maintains insertion order
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Inku", new Date()));
    }


    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User save(User user) {
        if(user.getId() == null){

            // returns value after increment
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    @Override
    public User findOne(int id) {

        for(User user :users) {

            if(user.getId() == id) {
                return user;
            }
        }
        return null;

        //return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public User deleteById(int id) {

        Iterator<User> iterator = users.iterator();

         while(iterator.hasNext()) {
             User user = iterator.next();
             if(user.getId() == id ) {
                 iterator.remove();
                 return user;
             }
         }
        return null;
    }
}
