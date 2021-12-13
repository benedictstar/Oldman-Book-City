package com.hh.controller;

import com.hh.entity.ShoppingList;
import com.hh.service.Impl.ShoppingServiceImpl;
import com.hh.service.ShoppingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shoppinglist")
public class shoppinglist extends HttpServlet {
    private ShoppingService shopping = new ShoppingServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("com_id");
        String tel=req.getParameter("tel");
        if(tel!=null){
            if(id!=null){
                shopping.addShopping(tel,Integer.parseInt(id),1);
            }
            ShoppingList shoppingList=shopping.searchShopping(tel);
            System.out.println(shoppingList.getCommodity().size());
            req.setAttribute("shoppinglist",shoppingList);
        }
        req.getRequestDispatcher("shopping.jsp").forward(req,resp);

    }
}
