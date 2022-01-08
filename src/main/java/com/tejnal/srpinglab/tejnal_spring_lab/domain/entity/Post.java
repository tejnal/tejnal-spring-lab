package com.tejnal.srpinglab.tejnal_spring_lab.domain.entity;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    // fetch them user information when it needed
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post() {

    }

    //A toString() is an in-built method in Java that returns the value given to it in string format.
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
