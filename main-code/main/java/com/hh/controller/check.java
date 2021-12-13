package com.hh.controller;

import com.hh.entity.TotalCheckHistory;
import com.hh.entity.User;
import com.hh.service.CheckService;
import com.hh.service.Impl.CheckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/mycheck")
public class check extends HttpServlet {
    CheckService checkService=new CheckServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        if(user!=null){
            TotalCheckHistory totalCheckHistory=checkService.getCheckHistory(user.getTel());
            req.setAttribute("totalCheckHistory",totalCheckHistory);
        }
        req.getRequestDispatcher("mycheck.jsp").forward(req,resp);


    }
}
