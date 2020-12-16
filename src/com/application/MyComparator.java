package com.application;

import com.application.model.User;

import java.util.Comparator;

public class MyComparator implements Comparator<User> {
    @Override
    public int compare(User obj1, User obj2) {
        return obj2.getUsername().compareTo(obj1.getUsername());
    }
}
