package com.Darkra1Zzz.dao.impl;

import com.Darkra1Zzz.dao.UserDao;
import com.Darkra1Zzz.entity.User;
import com.Darkra1Zzz.util.JDBCUtil_Cache;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    JDBCUtil_Cache util=JDBCUtil_Cache.getInit();
    public boolean checkName(String name){
        CachedRowSet rs=util.query("select * from t_user where name=?",name);
        try {
            if (rs.next()){
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public User login(String name, String password) {
        JDBCUtil_Cache util=JDBCUtil_Cache.getInit();
        User user=null;
        CachedRowSet rs=util.query("select * from t_user where name=? and password=?",name,password);
        try {
            if (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            util.closeCacheRowSet(rs);
        }
        return user;
    }


}
