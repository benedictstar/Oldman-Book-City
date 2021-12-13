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
    <title>老夫子二手书平台</title>
</head>
<body id="body">
<div>
    <div class="tit">老夫子旧书</div>
    <div style="display: flex;align-items: center;flex-direction: row;justify-content: center;align-items: center;height:550px;background: #0185FE">
        <div style="display: flex;align-items: center;flex-direction: column;flex-basis: 50%;font-size: 40px;color:white">
            欢迎登录
        </div>
        <div style="display: flex;align-items: center;flex-direction: column;flex-basis: 50%">
            <div style="height:300px;width:400px;background: white;display: flex;flex-direction: column;justify-content: center;align-items: center">
                <div style="font-size: 20px;font-weight: bold">管理员</div>
                <text style="color: red;margin-top: 10px" id="msg">${requestScope.msg}</text>
                <%--                    <div style="display: flex;flex-direction: row;justify-content:space-around;width:100%">--%>
                <%--                        --%>
                <%--                        <div style="font-size: 15px;color: #0185FE">立即注册</div>--%>
                <%--                    </div>--%>
                <form action="/login?type=2" method="post" style="margin-top: 30px;">
                    <div style="display: flex;flex-direction: column;width:300px;margin-left: 40px">
                        <div class="row">
                            <div style="flex-basis: 25%">管理名称:</div>
                            <input autocomplete="off" type="text" name="name" id="na" value="${requestScope.usname}"/>
                        </div>
                        <div class="row" style="margin-top: 20px">
                            <div style="flex-basis: 25%">管理密码:</div>
                            <input autocomplete="off" type="password" name="password" id="pa"/>
                        </div>
                    </div>
                    <div style="margin-top: 40px;margin-left: 40px">
                        <input type="submit" value="提交"  class="btn" style="margin-left: 30px"/>
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
    }
    .btn{
        width:200px;
        height:35px;
        background: #0185FE;
        color: white;
        outline: none;
        border: 1px solid #0185FE;
    }
</style>
</body>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script>
    $(function (){
        $("#na").click(function (){
            $("#msg").text("")
        })
        $("#pa").click(function (){
            $("#msg").text("")
        })
    })
</script>
</html>
