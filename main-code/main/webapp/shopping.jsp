<%--
  Created by IntelliJ IDEA.
  User: roseh
  Date: 2021/11/15
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
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
    <div style="margin:50px;display: flex;flex-direction: row;align-items:center ">
        <h1 style="color: #0185FE;letter-spacing: 5px;margin-left: 50px">老夫子旧书网</h1>
    </div>
    <div>
        <c:if test="${empty sessionScope.user}">
            <div style="display: flex;justify-content: center">
                <text>您还没有登录,</text>
                <a href="login.jsp">立即登录</a>
            </div>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <div style="width: 100%;">
                <table style="width: 100%;text-align: center">
                    <tr>
                        <th>商品名称</th>
                        <th>商品材质</th>
                        <th>商品价格</th>
                        <th>商品数量</th>
                        <th>总价格</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.shoppinglist.commodity}" var="com">
                        <tr style="height:60px">
                            <td>${com.commodityname}</td>
                            <td>${com.face}</td>
                            <td>${com.price}</td>
                            <td>${com.buynum}</td>
                            <td>${com.buynum*com.price}</td>
                            <td>
                                <div>
                                    <a href="/shoppingoperate?tel=${sessionScope.user.tel}&id=${com.com_id}&operate=1" style="text-decoration: none;color:#317ef3;">增加</a>
                                    <a href="/shoppingoperate?tel=${sessionScope.user.tel}&id=${com.com_id}&operate=2" style="text-decoration: none;color:#317ef3;">减少</a>
                                    <a href="/buy?tel=${sessionScope.user.tel}&id=${com.com_id}&type=1" style="text-decoration: none;color:#317ef3;">结算</a>
                                    <a href="/shoppingoperate?tel=${sessionScope.user.tel}&id=${com.com_id}&operate=3" style="text-decoration: none;color:#317ef3;">删除</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div style="margin:50px;display: flex;justify-content: flex-end;align-items: flex-end">
                <a href="/commodity" style="text-decoration: none;color: #317ef3">再去逛逛</a>
                <a href="/buy?tel=${sessionScope.user.tel}&type=2" class="btn">结算</a>
            </div>

        </c:if>
    </div>
    <style>
        .container {
            width: 500px;
            height: 50px;
            /*margin: 100px auto;*/
            margin-left: 600px;
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
        .btn{
            width:200px;
            height:35px;
            background: #0185FE;
            color: white;
            outline: none;
            border: 1px solid #0185FE;
            margin-left: 50px;
            margin-top: 30px;
            display: flex;
            justify-content: center;
            align-items: center;
            text-decoration: none
        }
    </style>
</body>
</html>
