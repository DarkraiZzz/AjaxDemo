package com.Darkra1Zzz.servlet;

import com.Darkra1Zzz.entity.User;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MultiParaServlet", value = "/MultiParaServlet")
public class MultiParaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        if ("case1".equals(from)) {
            if ("aa".equals(name)) {
                out.print("aa!男");
            }
            if ("bb".equals(name)) {
                out.print("bb!女");
            }
        } else if ("case2".equals(from)){
            User user=new User();
            if ("aa".equals(name)){
                user.setName("测试get1");
                user.setPassword("123");
            } if ("bb".equals(name)){
                user.setName("测试get2");
                user.setPassword("456");
            }
            Gson gson=new Gson();
            String str=gson.toJson(user);
            out.print(str);
        }
        else if ("case3".equals(from)){
            User user=new User();
            if ("aa".equals(name)){
                user.setName("测试a");
                user.setPassword("123");
            } if ("bb".equals(name)){
                user.setName("测试b");
                user.setPassword("456");
            }
            Gson gson=new Gson();
            String str=gson.toJson(user);
            out.print(str);
        }
        else if ("case4".equals(from)){
            User user=new User();
            if ("aa".equals(name)){
                user.setName("测试1");
                user.setPassword("123");
            } if ("bb".equals(name)){
                user.setName("测试2");
                user.setPassword("456");
            }
            Gson gson=new Gson();
            String str=gson.toJson(user);
            out.print(str);
        }
    }
}
