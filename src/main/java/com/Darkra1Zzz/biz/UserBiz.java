package com.Darkra1Zzz.biz;

import com.Darkra1Zzz.entity.User;

public interface UserBiz {
    public boolean checkName(String name);
    public User login(String name, String password);
}
