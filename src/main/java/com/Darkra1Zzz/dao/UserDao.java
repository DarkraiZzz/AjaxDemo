package com.Darkra1Zzz.dao;

import com.Darkra1Zzz.entity.User;

public interface UserDao {
    public boolean checkName(String name);
    public User login(String name, String password);
}
