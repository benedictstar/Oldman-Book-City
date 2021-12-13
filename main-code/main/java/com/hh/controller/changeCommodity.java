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

@WebServlet("/changeCommodity")
public class changeCommodity extends HttpServlet {
    private GetALLCommodityService getALLCommodityService=new GetAllCommodityServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int type=Integer.parseInt(req.getParameter("type"));
        String name=req.getParameter("name");
        double price=Double.parseDouble(req.getParameter("price"));
        String author=req.getParameter("author");
        String face=(String) req.getParameter("face");
        String url=req.getParameter("url");
        int num=Integer.parseInt(req.getParameter("num"));
        String detail=req.getParameter("detail");
        //type=1表示修改，type=2表示新增
        if(type==1){
            int id=Integer.parseInt(req.getParameter("id"));
            Commodity commodity=new Commodity(id,name,detail,author,price,url,face,0,num);
            getALLCommodityService.changeCommodity(commodity);
            resp.sendRedirect("/manager1?type=1");
        }
        else if(type==2){
            Commodity commodity=new Commodity(0,name,detail,author,price,url,face,0,num);
            boolean s=getALLCommodityService.addCommodity(commodity);
            if(s){
                resp.sendRedirect("manager1?type=1");
            }
            else{
                String msg="商品名称重复";
                req.setAttribute("msg",msg);
                req.getRequestDispatcher("addCommodity.jsp").forward(req,resp);
            }
        }







    }
}
