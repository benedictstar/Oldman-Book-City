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

@WebServlet("/shoppingoperate")
public class shoppingoperate extends HttpServlet {
    private ShoppingService shoppingService=new ShoppingServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String tel=req.getParameter("tel");
        int operate=Integer.parseInt(req.getParameter("operate"));
        switch (operate){
            case 1:{
                shoppingService.addShopping(tel,id,1);
                break;
            }
            case 2:{
                shoppingService.reduceShopping(tel,id,1);
                break;
            }
            case 3:{
                shoppingService.deleteShopping(tel,id);
                break;
            }
        }
        ShoppingList shoppingList=shoppingService.searchShopping(tel);
        req.setAttribute("shoppinglist",shoppingList);
        req.getRequestDispatcher("shopping.jsp").forward(req,resp);

    }
}
