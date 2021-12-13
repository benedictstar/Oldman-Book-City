<%--
  Created by IntelliJ IDEA.
  User: roseh
  Date: 2021/11/29
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
</head>
<body>
    <div class="tit">老夫子旧书</div>
    <div class="head">
        <div class="part"><a href="/manager1?type=1">商品管理</a></div>
        <div class="part"><a href="/manager1?type=4">用户浏览记录查询</a></div>
        <div class="part"><a href="/manager1?type=2">用户购买记录查询</a></div>
        <div class="part"><a href="/manager1?type=3">销售统计报表</a></div>
    </div>
    <div class="bot">
        <text style="font-size: 30px;">欢迎回来，管理员 <text style="color: #317ef3">${sessionScope.superuser.name}</text></text>
        <text style="font-size: 30px;margin-top: 30px">你可以根据上述选项查看二手书城后台信息</text>
    </div>
</body>
<style>
    .tit{
        font-weight: bold;
        font-size: 32px;
        color: #0185FE;
        width: 30%;
        text-align: center;
        height:100px;
        line-height:100px;
    }
    .head{
        display: flex;
        background: #317ef3;
        height:70px;
        color:white;
        justify-content:space-between;
        align-items: center;
    }
    .part{
        display: flex;
        justify-content: center;
        align-items: center;
        flex-basis: 25%;
    }
    .bot{
        height:200px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        margin-top: 150px;
    }
    a{
        text-decoration: none;
        color: white;
    }
</style>
</html>
