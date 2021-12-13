package com.hh.controller;

import com.hh.entity.Commodity;
import com.hh.service.GetALLCommodityService;
import com.hh.service.Impl.GetAllCommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comdetail")
public class managerDetail extends HttpServlet {
    private GetALLCommodityService getAllCommodityService=new GetAllCommodityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid=Integer.parseInt(req.getParameter("id"));
        int type=Integer.parseInt(req.getParameter("type"));
        //type=1是展示修改页面
        if(type==1){
            Commodity commodity=getAllCommodityService.searchCommodity(cid);
            req.setAttribute("commodity",commodity);
            req.getRequestDispatcher("commodityDetail.jsp").forward(req,resp);
        }
        if(type==2){
            getAllCommodityService.deleteCommodity(cid);
            resp.sendRedirect("/manager1?type=1");
        }


    }
}
