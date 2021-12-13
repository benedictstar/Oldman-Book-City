package com.hh.controller;

import com.hh.entity.SuperUser;
import com.hh.entity.User;
import com.hh.service.Impl.LoginServiveImpl;
import com.hh.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginSeverlet extends HttpServlet {
    private LoginService loginService=new LoginServiveImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        设置编码格式为utf-8
        req.setCharacterEncoding("UTF-8");
//        获取type，用type判断处理的是管理员登录页面还是用户登录页面
        int type=Integer.parseInt(req.getParameter("type"));
//        获取用户名和密码
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        System.out.println(name);
        //用户登录管理
        if(type==1){
            //调用登录功能函数
            User user=loginService.login(name,password);
            //判断用户是否存在，存在就在session中注册
            if(user!=null){
                HttpSession session=req.getSession();
                session.setAttribute("user",user);
                resp.sendRedirect("/commodity");
            }
            //如果和数据库不匹配那么就返回错误信息回原页面
            else{
                req.setAttribute("msg","请输入正确的用户名和密码");
                req.setAttribute("usname",name);
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        }
        //管理员登录管理
        else if(type==2){
            SuperUser user=loginService.superlogin(name,password);
            if(user!=null){
                HttpSession session=req.getSession();
                session.setAttribute("superuser",user);
                resp.sendRedirect("managershow.jsp");
            }
            else{
                req.setAttribute("msg","请输入正确的用户名和密码");
                req.setAttribute("usname",name);
                req.getRequestDispatcher("managerlogin.jsp").forward(req,resp);
            }
        }



    }
}
