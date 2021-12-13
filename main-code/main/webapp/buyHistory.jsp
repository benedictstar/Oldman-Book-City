<%--
  Created by IntelliJ IDEA.
  User: roseh
  Date: 2021/11/29
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>销售报表</title>
</head>
<body>
<div style="margin:50px;display: flex;flex-direction: row;align-items:center;margin-bottom: 25px">
    <h1 style="color: #0185FE;letter-spacing: 5px;margin-left: 50px">老夫子后台管理</h1>
<%--    <div class="container">--%>
<%--        <form action="login.jsp" method="post" class="parent">--%>
<%--            <input type="text">--%>
<%--            <input type="submit" value="搜索">--%>
<%--        </form>--%>
<%--    </div>--%>
</div>

<div style="display: flex;justify-content: center;font-size: 30px;color: #317ef3;">销售总额：${requestScope.sum}</div>
<div style="width: 100%;display: flex;justify-content: center">
    <table style="width: 1400px;text-align: center;margin: 50px">
        <tr>
            <th>购买记录编号</th>
            <th>购买人手机号</th>
            <th>商品名称</th>
            <th>商品购买数量</th>
            <th>本次购买总金额</th>
            <th>购买时间</th>
        </tr>
        <c:forEach items="${requestScope.totalBuyHistory.buyHistories}" var="com">
            <tr style="height:60px">
                <td>${com.id}</td>
                <td>${com.usertel}</td>
                <td>${com.commodity_name}</td>
                <td>${com.num}</td>
                <td>${com.commodity_price*com.num}</td>
                <td style="width:250px">${com.date}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div style="margin-right: 100px;display: flex;justify-content: flex-end;margin-bottom: 50px"><a href="managershow.jsp" style="color: #317ef3">返回首页</a></div>
</body>
<style>
    td{
        width: 50px;
    }
    .spe{
        white-space: initial;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-box-orient:vertical;
        -webkit-line-clamp: 1;
        /*text-align: left;*/
    }
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
</html>
