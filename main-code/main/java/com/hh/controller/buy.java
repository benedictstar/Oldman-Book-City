package com.hh.controller;

import com.hh.entity.ShoppingList;
import com.hh.entity.User;
import com.hh.service.BuyService;
import com.hh.service.GetALLCommodityService;
import com.hh.service.Impl.BuyServiceImpl;
import com.hh.service.Impl.GetAllCommodityServiceImpl;
import com.hh.service.Impl.ShoppingServiceImpl;
import com.hh.service.ShoppingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/buy")
public class buy extends HttpServlet {
    private BuyService buyService=new BuyServiceImpl();
    private ShoppingService shoppingService=new ShoppingServiceImpl();
    private GetALLCommodityService getALLCommodityService=new GetAllCommodityServiceImpl();
    private sendEmail sendEmail=new sendEmail();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tel=req.getParameter("tel");
//        如果用户没有登录，跳转登录页
        if(tel==""){
            resp.sendRedirect("login.jsp");
        }
        //
        else{
            int type=Integer.parseInt(req.getParameter("type"));
            Date date=new Date();
            //如果type=1则说明是结算或购买单个商品
            if(type==1){
                int id=Integer.parseInt(req.getParameter("id"));
                int buynum=shoppingService.getShopping(tel,id);
                //如果buynum=0说明是在立即购买出的操作，默认只购买一件商品
                if(buynum==0){
                    buyService.addBuyHistory(tel,id,1,date);
                    getALLCommodityService.reduceCommodity(id,1);
                }
                //否则就是在购物车页的结算
                else{
                    buyService.addBuyHistory(tel,id,buynum,date);
                    shoppingService.deleteShopping(tel,id);
                    getALLCommodityService.reduceCommodity(id,buynum);
                }
            }
            //清空购物车操作
            else if(type==2){
                ShoppingList shoppingList=shoppingService.searchShopping(tel);
                for(int i=0;i<shoppingList.getCommodity().size();i++){
                    int id=shoppingList.getCommodity().get(i).getCom_id();
                    int buynum=shoppingList.getCommodity().get(i).getBuynum();
                    buyService.addBuyHistory(tel,id,buynum,date);
                    shoppingService.deleteShopping(tel,id);
                    getALLCommodityService.reduceCommodity(id,buynum);
                }
            }
            sendEmail.sendEmail((User) req.getSession().getAttribute("user"));
            req.getRequestDispatcher("finalpage.jsp").forward(req,resp);
        }



    }
}
