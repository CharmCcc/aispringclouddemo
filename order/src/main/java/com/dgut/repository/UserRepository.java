package com.dgut.repository;

import com.dgut.entity.User;

import java.util.List;

public interface UserRepository {
    public User findById(long id);
}
