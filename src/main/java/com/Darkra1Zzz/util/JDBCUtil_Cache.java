package com.Darkra1Zzz.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * @Author DarkraiZzz
 * @Time 2021/7/12 16:52
 * @Version 1.0
 */
public class JDBCUtil_Cache {
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/test9?&useSSL=false&serverTimezone=GMT%2B8";
    public static final String name = "root";
    public static final String pwd = "123456";

    public void getConnection() {
        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, name, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeAll() {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection con = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    private static JDBCUtil_Cache util;

    private JDBCUtil_Cache() {
    }

    public synchronized static JDBCUtil_Cache getInit() {
        if (util == null) {
            util = new JDBCUtil_Cache();
        }
        return util;
    }

    /**
     * 添加，删除，修改 传参可能是0-N个 Object ...obj
     */
    public boolean update(String sql, Object... obj) {
        getConnection();
        try {
            ps = con.prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }


    public CachedRowSet query(String sql, Object... obj) {
        getConnection();
        CachedRowSet rowset = null;
        try {
            ps = con.prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            rs = ps.executeQuery();
            rowset = new CachedRowSetImpl();
            rowset.populate(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return rowset;

    }


    public void closeCacheRowSet(CachedRowSet rs) {
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
