package com.tejnal.srpinglab.tejnal_spring_lab.domain.controller;

import com.tejnal.srpinglab.tejnal_spring_lab.domain.entity.User;
import com.tejnal.srpinglab.tejnal_spring_lab.domain.service.UserServiceImpl;
import com.tejnal.srpinglab.tejnal_spring_lab.exception.UserNotFoundException;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResourceController {

  private UserServiceImpl userServiceImpl;

  public UserResourceController(UserServiceImpl userServiceImpl) {
    this.userServiceImpl = userServiceImpl;
  }

  @GetMapping("/users")
  public List<User> retrieveAllUsers() {
    return userServiceImpl.findAll();
  }

  @GetMapping("/users/{id}")
  public EntityModel<User> retrieveUser(@PathVariable int id) {
    User user = userServiceImpl.findOne(id);
    if (user == null) {

      throw new UserNotFoundException("id-" + id);
    }
    //HATEOAS
    EntityModel<User> resource = EntityModel.of(user);

    WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
    resource.add(linkBuilder.withRel("all-users"));

    return resource;
  }
}
