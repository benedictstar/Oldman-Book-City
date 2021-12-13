<%--
  Created by IntelliJ IDEA.
  User: roseh
  Date: 2021/11/9
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>商品修改页</title>
</head>
<body id="body">
<div>
    <div class="tit">老夫子后台管理系统</div>
    <div style="display: flex;align-items: center;flex-direction: row;justify-content: center;align-items: center;height:650px;background: #0185FE">
        <div style="display: flex;align-items: center;flex-direction: column;flex-basis: 50%">
            <div style="height:575px;width:400px;background: white;display: flex;flex-direction: column;justify-content: center;align-items: center">
                <div style="font-size: 20px;font-weight: bold">商品修改</div>
<%--                <text style="color: red;margin-top: 10px" id="msg">${requestScope.msg}</text>--%>
                <%--                    <div style="display: flex;flex-direction: row;justify-content:space-around;width:100%">--%>
                <%--                        --%>
                <%--                        <div style="font-size: 15px;color: #0185FE">立即注册</div>--%>
                <%--                    </div>--%>
                <form action="/changeCommodity?type=1" method="post" style="margin-top: 30px;" accept-charset="UTF-8">
                    <div style="display: flex;flex-direction: column;width:300px;margin-left: 40px">
                        <div class="row">
                            <div style="flex-basis: 25%">商品id:</div>
                            <input type="text" name="id"  value="${requestScope.commodity.com_id}"/>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品名称:</div>
                            <input type="text" name="name"  value="${requestScope.commodity.commodityname}"/>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品价格:</div>
                            <input type="text" name="price"  value="${requestScope.commodity.price}"/>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品作者:</div>
                            <input type="text" name="author"  value="${requestScope.commodity.author}"/>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品材质:</div>
                            <input type="text" name="face"  value="${requestScope.commodity.face}"/>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品url:</div>
                            <input type="text" name="url"  value="${requestScope.commodity.url}"/>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品库存:</div>
                            <input type="text" name="num"  value="${requestScope.commodity.totalnum}"/>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品详情:</div>
                            <textarea name="detail">${requestScope.commodity.detail}</textarea>
<%--                            <input type="text" name="detail"  value="${requestScope.commodity.detail}">--%>
                        </div>
                    </div>
                    <div style="margin-top: 40px;margin-left: 40px">
                        <input type="submit" value="修改"  class="btn" style="margin-left: 30px"/>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>

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
    .row{
        display: flex;
        flex-direction: row;
        /*align-items: center;*/
        height:50px;
    }
    .btn{
        width:200px;
        height:35px;
        background: #0185FE;
        color: white;
        outline: none;
        border: 1px solid #0185FE;
    }
    input{
        height:20px;
    }
    textarea{
        height:80px;
        resize: none;
    }
</style>
</body>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</html>
