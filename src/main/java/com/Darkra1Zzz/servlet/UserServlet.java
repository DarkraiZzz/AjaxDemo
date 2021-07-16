package com.Darkra1Zzz.servlet;

import com.Darkra1Zzz.biz.UserBiz;
import com.Darkra1Zzz.biz.impl.UserBizImpl;
import com.Darkra1Zzz.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        response.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        ServletContext application=getServletContext();
        String method = request.getParameter("method");
        if ("register".equals(method)) {
            this.register(request, response);
        }if ("login".equals(method)) {
            this.login(request, response);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        UserBiz userBiz=new UserBizImpl();
        String uname=request.getParameter("uname");
        boolean flag=userBiz.checkName(uname);
        PrintWriter out=response.getWriter();
        out.print("<h1>你好,Darkra1</h1>");
        out.print(flag?"用户名可用":"用户名已存在");//可用1
        out.flush();
        out.close();
    }

    private void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        UserBiz userBiz=new UserBizImpl();
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        User user=userBiz.login(name,password);
        System.out.println(user);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PrintWriter out=response.getWriter();
        out.print(user==null?"1":"0");//可用1
        out.flush();
        out.close();
    }

}
