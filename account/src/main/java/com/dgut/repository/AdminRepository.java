package com.dgut.repository;

import com.dgut.entity.Admin;

public interface AdminRepository {
    public Admin login(String username,String password);
}
