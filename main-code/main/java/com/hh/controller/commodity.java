package com.hh.controller;

import com.hh.entity.Commodity;
import com.hh.entity.TotalCommodity;
import com.hh.service.GetALLCommodityService;
import com.hh.service.Impl.GetAllCommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/commodity")
public class commodity extends HttpServlet {
    private GetALLCommodityService getAllCommodityService=new GetAllCommodityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //type=表示没有搜索，返回所有的商品，type=1则是搜索
        int type=0;
        req.setCharacterEncoding("UTF-8");
        if(req.getParameter("type")!=null){
            type=Integer.parseInt(req.getParameter("type"));
        }
        TotalCommodity totalCommodity=null;
//        返回搜索目标的商品
        if(type==1){
            String name=req.getParameter("name");
            String str="《";
            str=str+name+"》";
            totalCommodity=getAllCommodityService.searchCommodityByName(str);
        }
//        返回所有的商品
        else{
            totalCommodity=getAllCommodityService.getAllCommodity();
        }
        List<Commodity> c=totalCommodity.getCommodities();
        req.setAttribute("totalCommodity",totalCommodity);
        req.setAttribute("num",Math.ceil(c.size()/3.0));
        req.getRequestDispatcher("firstpage.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //type=表示没有搜索，返回所有的商品，type=1则是搜索
//        int type=Integer.parseInt(req.getParameter("type"));
//        //返回所有的商品
//        if(type==0){
//            System.out.println("这是");
//            System.out.println(type);
//            TotalCommodity totalCommodity=getAllCommodityService.getAllCommodity();
//            req.setAttribute("totalCommodity",totalCommodity);
//            req.setAttribute("h",1);
//            req.getRequestDispatcher("firstpage.jsp").forward(req,resp);
//        }
        doGet(req,resp);
    }
}
