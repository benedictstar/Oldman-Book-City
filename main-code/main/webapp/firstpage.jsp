<%--
  Created by IntelliJ IDEA.
  User: roseh
  Date: 2021/11/9
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<head>
    <title>老夫子旧书平台</title>
</head>
<body style="background: #F5F5F5">
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
    <div style="margin-top:25px;height:100px;margin-left: 50px;display: flex;flex-direction: row;align-items: center;">
        <img src="static/logo.webp" width="80" height="80"/>
        <img src="static/logo2.jfif" width="80" height="80" style="margin-left: 50px"/>
        <a href="" style="color: black;font-weight: bold;margin-left: 200px;text-decoration: none">古籍</a>
        <a href="" style="color: black;font-weight: bold;margin-left: 25px;text-decoration: none">民国笔迹</a>
        <a href="" style="color: black;font-weight: bold;margin-left: 25px;text-decoration: none">海外孤本</a>
        <a href="" style="color: black;font-weight: bold;margin-left: 25px;text-decoration: none">大师笔迹</a>
        <div class="container">
            <form action="/commodity?type=1" method="post" class="parent">
                <input type="text" placeholder="请输入完整书名查找，无需带上书名号" name="name">
                <input type="submit" value="搜索">
            </form>
        </div>
    </div>
    <div style="display: flex;justify-content: flex-end;margin-top: 25px;margin-right: 150px">
        <c:if test="${ not empty sessionScope.user}">
            <text>欢迎回来,</text>
            <text style="color:#317ef3;">${sessionScope.user["name"]}</text>
        </c:if>
    </div>
    <div style="margin-left: 50px;margin-right: 50px;margin-top: 50px;margin-bottom: 100px">
        <c:if test="${requestScope.num==0}">
            <text style="display: flex;justify-content: center;color: #317ef3;letter-spacing: 2px">搜索结果空空如也,点击导航栏回到首页</text>
        </c:if>
        <c:if test="${requestScope.num!=0}">
            <div style="font-size: 25px;display: flex;flex-direction: row;width:200px;background: white">
                <div style="height: 50px;width: 30px;background: #0185FE"></div>
                <text style="line-height: 50px;margin-left: 25px">优书推荐</text>
            </div>
            <c:forEach begin="0" end="${requestScope.num}" varStatus="big">
                <div style="display: flex;flex-direction: row;justify-content: space-between;margin-left: 100px;margin-right: 100px;margin-top: 50px">
                    <c:forEach items="${requestScope.totalCommodity.commodities}" var="commodity" varStatus="status">
                        <c:if test="${status.index<3*(big.index+1) and status.index>=3*big.index}">
                            <div style="height:420px;width:300px;background: white">
                                <div style="margin-left: 50px;margin-right: 50px;margin-top: 30px"><a href="/detail?id=${commodity.com_id}"><img src="${commodity.url}" width="200" height="250"/></a></div>
                                <div class="infmation">
                                    <text style="font-size: 16px;font-weight: bold;letter-spacing: 1px">${commodity.commodityname}</text>
                                    <div style="display: flex;flex-direction: row;margin-top: 40px;width:250px;justify-content: space-between;align-items: center">
                                        <div style="margin-left: 15px;">
                                            <text style="font-size: 20px">￥</text>
                                            <text>${commodity.price}</text>
                                        </div>
                                        <div class="btn"><a href="/shoppinglist?tel=${sessionScope.user.tel}&com_id=${commodity.com_id}" style="color:white;text-decoration: none">加入购物车</a></div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <style>
        .container {
            width: 500px;
            height: 50px;
            /*margin: 100px auto;*/
            margin-left: 200px;
        }
        .parent {
            width: 100%;
            height: 42px;
            top: 4px;
            position: relative;
        }
        .parent>input:first-of-type {
            /*输入框高度设置为40px, border占据2px，总高度为42px*/
            width: 380px;
            height: 40px;
            border: 1px solid #ccc;
            font-size: 16px;
            outline: none;
        }
        .parent>input:first-of-type:focus {
            border: 1px solid #317ef3;
            padding-left: 10px;
        }
        .parent>input:last-of-type {
            /*button按钮border并不占据外围大小，设置高度42px*/
            width: 100px;
            height: 44px;
            position: absolute;
            background: #317ef3;
            border: 1px solid #317ef3;
            color: #fff;
            font-size: 16px;
            outline: none;
        }
        .infmation{
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .parent2{
            margin-top: 10px;
        }
        .parent2>input:last-of-type{
            width: 100px;
            height: 40px;
            background: #317ef3;
            border: 1px solid #317ef3;
            color: #fff;
            font-size: 14px;
            outline: none;

        }
        .btn{
            width:100px;
            height:35px;
            background: #0185FE;
            color: white;
            outline: none;
            border: 1px solid #0185FE;
            display: flex;
            justify-content: center;
            align-items: center;
        }

    </style>
</body>
</html>
