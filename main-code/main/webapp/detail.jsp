<%--
  Created by IntelliJ IDEA.
  User: roseh
  Date: 2021/11/15
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情页</title>
</head>
<body style="ackground: #F5F5F5">
    <div style="background: black;color:white;height:40px;display: flex;flex-direction: row;align-items: center;font-size: 13px">
        <div style="flex-basis: 60%;margin-left: 80px">
            <a style="color:white;text-decoration: none">老夫子二手书商城</a>
            <text> | </text>
            <a style="color:white;text-decoration: none">老夫子二手书移动版</a>
            <text> | </text>
            <a style="color:white;text-decoration: none">问题反馈</a>
        </div>
        <div>
            <c:if test="${ empty sessionScope.user}">
                <a href="login.jsp" style="color:white;text-decoration: none">登录</a>
                <text> | </text>
                <a href="register.jsp" style="color:white;text-decoration: none;">注册</a>
                <text> | </text>
            </c:if>
            <c:if test="${  not empty sessionScope.user}">
                <a href="/logout" style="color:white;text-decoration: none">注销</a>
                <text> | </text>
            </c:if>
            <a href="/commodity" style="color:white;text-decoration: none">首页</a>
            <text> | </text>
            <a href="/order" style="color:white;text-decoration: none">我的订单</a>
            <text> | </text>
            <a href="/mycheck" style="color:white;text-decoration: none">浏览记录</a>
            <text> | </text>
            <a href="managerlogin.jsp" style="color:white;text-decoration: none;">管理员登录</a>
        </div>
        <div style="height:40px;width:120px;background: red;margin-left:20px;display: flex;flex-direction: row;justify-content: center;align-items: center">
            <a href="/shoppinglist?tel=${sessionScope.user.tel}" style="font-size: 15px;color: white;text-decoration: none;style="margin-left: 5px;"">购物车</a>
        </div>
    </div>
    <div style="display: flex;flex-direction: row;height:500px;margin: 50px;margin-top: 100px">
        <div style="margin-left: 100px;">
            <img src="${requestScope.commodity.url}" width="300" height="400"/>
        </div>
        <div style="margin-left: 80px;width:700px">
            <h2>${requestScope.commodity.detail}</h2>
            <div style="border:1px solid #d9dbd2;height:70px;width:100%">
                <div style="margin-left: 30px;font-size: 13px">
                    <div class="label">
                        <text style="flex-basis: 33%">作者：${requestScope.commodity.author}</text>
                        <text style="flex-basis: 33%">出版时间：2021.9.1</text>
                        <text style="flex-basis: 33%">开本: 	16开</text>
                    </div>
                    <div class="label">
                        <text style="flex-basis: 33%">出版社: 三联书店</text>
                        <text style="flex-basis: 33%">版次: 	1</text>
                        <text style="flex-basis: 33%">纸张: 	胶版纸</text>
                    </div>
                    <div class="label" >
                        <text style="flex-basis: 33%">ISBN: 	212343444</text>
                        <text style="flex-basis: 33%">装帧: 	其他</text>
                    </div>
                </div>
            </div>
            <div style="background: #c5daf0;height:130px;width:100%;margin-top: 30px;font-size:15px;">
                <div class="litlabel">
                    <text style="color:#a1a1a1">价格</text>
                    <text style="margin-left: 40px;color: #b81818">￥</text>
                    <text style="color: #b81818;font-size: 18px"> ${requestScope.commodity.price}</text>
                </div>
                <div class="litlabel">
                    <text style="color:#a1a1a1">品相</text>
                    <text style="color: #b81818;font-size: 13px;margin-left: 50px">${requestScope.commodity.face}</text>
                </div>
                <div class="litlabel">
                    <text style="color:#a1a1a1">优惠</text>
                    <text style="font-size: 13px;margin-left: 40px">满99元包邮</text>
                </div>
            </div>
            <div style="display: flex;flex-basis: row">
                <div class="btn" style="background: #b81818"><a href="/buy?tel=${sessionScope.user.tel}&id=${requestScope.commodity.com_id}&type=1" style="color:white;text-decoration: none" >立即购买</a></div>
                <div class="btn"><a href="/shoppinglist?tel=${sessionScope.user.tel}&com_id=${requestScope.commodity.com_id}" style="color:white;text-decoration: none">加入购物车</a></div>
<%--                <input type="submit" value="立即购买"  class="btn" style="background: #b81818" />--%>
<%--                <a href="#" class="btn">加入购物车</a>--%>
<%--                <input type="submit" value="加入购物车"  class="btn" />--%>
            </div>
        </div>
    </div>
    <style>
        .label{
            display: flex;
            flex-direction: row;
            margin-top: 10px;
            margin-top: 6px;
        }
        .litlabel{
            margin-left: 20px;
            padding-top: 20px;
        }
        .btn{
            width:200px;
            height:35px;
            background: #0185FE;
            color: white;
            outline: none;
            border: 1px solid #0185FE;
            margin-left: 100px;
            margin-top: 30px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</body>
</html>
