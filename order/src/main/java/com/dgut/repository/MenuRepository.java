package com.dgut.repository;

import com.dgut.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public Menu findById(long id);
}
