package com.Darkra1Zzz.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TemplateServlet", value = "/TemplateServlet")
public class TemplateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        ServletContext application=getServletContext();
        PrintWriter out=response.getWriter();
        out.print("<h1>你好,Darkra1</h1>");
        out.flush();
        out.close();
    }
}
