package com.Darkra1Zzz.servlet;

import com.Darkra1Zzz.entity.Dept;
import com.Darkra1Zzz.entity.Emp;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpDeptServlet", value = "/EmpDeptServlet")
public class EmpDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from=request.getParameter("from");
        if ("dept".equals(from)){
            List<Dept> deptList=new ArrayList<>();
            deptList.add(new Dept(1,"技术部"));
            deptList.add(new Dept(2,"人事部"));
            request.setAttribute("deptList",deptList);
            request.getRequestDispatcher("empdept.jsp").forward(request,response); //empdept.jsp 拼接table返回。  empdept2.jsp 跳转到新页面整个table返回。
        }else if ("emp".equals(from)){
            PrintWriter out=response.getWriter();
            int did=Integer.valueOf(request.getParameter("did"));
            System.out.println(did);
            List<Emp> empList=new ArrayList<>();
            if (did==1){
                empList.add(new Emp(1,"张工程师"));
                empList.add(new Emp(2,"陈工程师"));
                empList.add(new Emp(3,"王工程师"));
                empList.add(new Emp(4,"李工程师"));
            }else {
                empList.add(new Emp(1,"张经理"));
                empList.add(new Emp(2,"陈经理"));
                empList.add(new Emp(3,"王经理"));
                empList.add(new Emp(4,"李经理"));
            }
            Gson gson=new Gson();
            String str=gson.toJson(empList);
            System.out.println(str);
            out.print(str);
            out.flush();
            out.close();
        }else if ("emp2".equals(from)){
            int did=Integer.valueOf(request.getParameter("did"));
            System.out.println(did);
            List<Emp> empList=new ArrayList<>();
            if (did==1){
                empList.add(new Emp(1,"张工程师"));
                empList.add(new Emp(2,"陈工程师"));
                empList.add(new Emp(3,"王工程师"));
                empList.add(new Emp(4,"李工程师"));
            }else {
                empList.add(new Emp(1,"张经理"));
                empList.add(new Emp(2,"陈经理"));
                empList.add(new Emp(3,"王经理"));
                empList.add(new Emp(4,"李经理"));
            }
            request.setAttribute("empList",empList);
            request.getRequestDispatcher("empdept2_emp.jsp").forward(request,response);
        }
    }
}
