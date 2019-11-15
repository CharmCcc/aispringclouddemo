package com.dgut.repository;

import com.dgut.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
