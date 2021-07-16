package com.Darkra1Zzz.util;

/**
 * @Author Darkrai
 * @Date: 2021/6/2 16:08
 * @Version 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/test9?&useSSL=false&serverTimezone=GMT%2B8";
    public static final String name = "root";
    public static final String pwd = "123456";
    public Connection con = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;


    private static JDBCUtil util;
    private JDBCUtil() {}
    public synchronized  static JDBCUtil getInit() {
        if(util==null) {
            util=new JDBCUtil();
        }
        return util;
    }


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

    public ResultSet query(String sql, Object... obj) {
        getConnection();
        try {
            ps = con.prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}

