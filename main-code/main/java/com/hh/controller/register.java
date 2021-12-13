package com.hh.controller;

import com.hh.entity.User;
import com.hh.service.Impl.RegisterServiceImpl;
import com.hh.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class register extends HttpServlet {
    private RegisterService registerService=new RegisterServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        设置编码格式为utf-8
        req.setCharacterEncoding("UTF-8");
        //接收用户输入
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String tel=req.getParameter("tel");
        String email=req.getParameter("email");
        //调用service层接口
        int flag=registerService.register(name,password,tel,email);
        //flag=0说明用户信息合法，允许注册并登录
        if(flag==0){
            User user=new User(name,password,tel,email);
            HttpSession session= req.getSession();
            session.setAttribute("user",user);
//            req.getRequestDispatcher("firstpage.jsp").forward(req,resp);
            resp.sendRedirect("/commodity");
        }
//        flag=1，2，3说明信息不合法，需要重新输入注册信息
        else if(flag==1){
            System.out.println("用户名重复");
            req.setAttribute("msg","用户名重复");

            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
        else if(flag==2){
            System.out.println("电话重复");
            req.setAttribute("msg","电话重复");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
        else if(flag==3){
            System.out.println("邮箱重复");
            req.setAttribute("msg","邮箱重复");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }

    }
}
