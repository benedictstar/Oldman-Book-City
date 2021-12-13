package com.hh.controller;

import com.hh.entity.TotalBuyHistory;
import com.hh.entity.TotalCheckHistory;
import com.hh.service.BuyService;
import com.hh.service.CheckService;
import com.hh.service.Impl.BuyServiceImpl;
import com.hh.service.Impl.CheckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/log")
public class log extends HttpServlet {
    private CheckService checkService=new CheckServiceImpl();
    private BuyService buyService=new BuyServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int type=Integer.parseInt(req.getParameter("type"));
        String tel=req.getParameter("tel");
        //分发两个查询操作，type=1是浏览记录的查询操作，type=2是购买记录的查询
        if(type==1){
            TotalCheckHistory totalCheckHistory=checkService.getCheckHistory(tel);
            req.setAttribute("totalCheckHistory",totalCheckHistory);
            req.getRequestDispatcher("userCheckHistory.jsp").forward(req,resp);
        }
        if(type==2){
            TotalBuyHistory totalBuyHistory=buyService.getBuyHistory(tel);
            req.setAttribute("totalBuyHistory",totalBuyHistory);
            req.getRequestDispatcher("userbuyHistory.jsp").forward(req,resp);
        }
    }


}
