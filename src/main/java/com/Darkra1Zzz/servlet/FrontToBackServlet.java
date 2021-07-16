package com.Darkra1Zzz.servlet;

import com.Darkra1Zzz.biz.UserBiz;
import com.Darkra1Zzz.biz.impl.UserBizImpl;
import com.Darkra1Zzz.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FrontToBackServlet", value = "/FrontToBackServlet")
public class FrontToBackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("send".equals(method)) {
            this.send(request, response);
        }if ("send2".equals(method)) {
            this.send2(request, response);
        }if ("send3".equals(method)) {
            this.send3(request, response);
        }
    }
    private void send(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String str=request.getParameter("user");
        Gson gson=new Gson();
//        gson.toJson(对象)把对象转换成字符串传到前端
        User user=gson.fromJson(str,User.class); //将字符串转化为对象
        System.out.println(user);
        PrintWriter out=response.getWriter();
        out.print("后端接收到了，并返回"+user.getName());
        out.flush();
        out.close();
    }
    private void send2(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String str=request.getParameter("users");
        Gson gson=new Gson();
//        gson.toJson(对象)把对象转换成字符串传到前端

        List<User> users=gson.fromJson(str,new TypeToken<List<User>>(){}.getType());
        for (User u:users){
            System.out.println(u);
        }
        PrintWriter out=response.getWriter();
        out.print("后端接收到了，并返回"+users.size());
        out.flush();
        out.close();
    }
    private void send3(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String str=request.getParameter("str");
        Gson gson=new Gson();
//        gson.toJson(对象)把对象转换成字符串传到前端
        Map<String,Object> map=gson.fromJson(str,new TypeToken<Map<String,Object>>(){}.getType());
        System.out.println(map.get("num"));
        System.out.println(map.get("msg"));
        User user=gson.fromJson(map.get("user").toString(),User.class);
        System.out.println(user);
        String u=gson.toJson(user);
        PrintWriter out=response.getWriter();
        out.print("copy that,return"+u);
        out.flush();
        out.close();
    }
}
