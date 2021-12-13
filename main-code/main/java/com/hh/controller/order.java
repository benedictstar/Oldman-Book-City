package com.hh.controller;

import com.hh.entity.TotalBuyHistory;
import com.hh.entity.User;
import com.hh.service.BuyService;
import com.hh.service.Impl.BuyServiceImpl;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/order")
public class order extends HttpServlet {
    BuyService buyService=new BuyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        User user=(User)session.getAttribute("user");
        if(user!=null){
            TotalBuyHistory totalBuyHistory=buyService.getBuyHistory(user.getTel());
            req.setAttribute("totalBuyHistory",totalBuyHistory);
        }
        req.getRequestDispatcher("myorder.jsp").forward(req,resp);
    }
}
