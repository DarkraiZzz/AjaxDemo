package com.Darkra1Zzz.biz.impl;

import com.Darkra1Zzz.biz.UserBiz;
import com.Darkra1Zzz.dao.UserDao;
import com.Darkra1Zzz.dao.impl.UserDaoImpl;
import com.Darkra1Zzz.entity.User;

public class UserBizImpl implements UserBiz {
    UserDao dao=new UserDaoImpl();
    public boolean checkName(String name){
        if (name==null||"".equals(name)||name.length()<3){
            return false;
        }
        return dao.checkName(name);
    }

    @Override
    public User login(String name, String password) {
        return dao.login(name,password);
    }
}
