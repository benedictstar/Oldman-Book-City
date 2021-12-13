package com.hh.controller;

import com.hh.entity.Commodity;
import com.hh.entity.User;
import com.hh.service.CheckService;
import com.hh.service.GetALLCommodityService;
import com.hh.service.Impl.CheckServiceImpl;
import com.hh.service.Impl.GetAllCommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/detail")
public class detail extends HttpServlet {
    private GetALLCommodityService getAllCommodityService=new GetAllCommodityServiceImpl();
    private CheckService checkService=new CheckServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid=Integer.parseInt(req.getParameter("id"));
        //添加浏览记录
        if(req.getSession().getAttribute("user")!=null){
            User user=(User)req.getSession().getAttribute("user");
            Date date =new Date();
            checkService.addCheckHistory(user.getTel(),cid,date);
        }
        //根据id搜索商品信息
        Commodity commodity=getAllCommodityService.searchCommodity(cid);
        req.setAttribute("commodity",commodity);
        req.getRequestDispatcher("detail.jsp").forward(req,resp);
    }
}
