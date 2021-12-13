package com.hh.controller;

import com.hh.entity.Commodity;
import com.hh.entity.TotalBuyHistory;
import com.hh.entity.TotalCheckHistory;
import com.hh.entity.TotalCommodity;
import com.hh.service.BuyService;
import com.hh.service.CheckService;
import com.hh.service.GetALLCommodityService;
import com.hh.service.Impl.BuyServiceImpl;
import com.hh.service.Impl.CheckServiceImpl;
import com.hh.service.Impl.GetAllCommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager1")
public class manager extends HttpServlet {
    private GetALLCommodityService getAllCommodityService=new GetAllCommodityServiceImpl();
    private BuyService buyService=new BuyServiceImpl();
    private CheckService checkService=new CheckServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //type为1则是商品展示，为2是购买记录，3为销售报表，4是浏览记录
        int type=Integer.parseInt(req.getParameter("type"));
        if(type==1){
            TotalCommodity totalCommodity=getAllCommodityService.getAllCommodity();
            req.setAttribute("totalCommodity",totalCommodity);
            req.getRequestDispatcher("managercommodity.jsp").forward(req,resp);
        }
        else if(type==2){
            resp.sendRedirect("userbuyHistory.jsp");
        }
        else if(type==3){
            TotalBuyHistory totalBuyHistory=buyService.getBuyHistory();
            double sum=0;
            for(int i=0;i<totalBuyHistory.getBuyHistories().size();i++){
                sum+=totalBuyHistory.getBuyHistories().get(i).getCommodity_price()*totalBuyHistory.getBuyHistories().get(i).getNum();
            }
            req.setAttribute("sum",sum);
            req.setAttribute("totalBuyHistory",totalBuyHistory);
            req.getRequestDispatcher("buyHistory.jsp").forward(req,resp);
        }
        else if(type==4){
            resp.sendRedirect("userCheckHistory.jsp");
        }

    }
}
