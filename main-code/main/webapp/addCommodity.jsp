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
    <title>商品增加页</title>
</head>
<body id="body">
<div>
    <div class="tit">老夫子后台管理系统</div>
    <div style="display: flex;align-items: center;flex-direction: row;justify-content: center;align-items: center;height:650px;background: #0185FE">
        <div style="display: flex;align-items: center;flex-direction: column;flex-basis: 50%">
            <div style="height:575px;width:400px;background: white;display: flex;flex-direction: column;justify-content: center;align-items: center">
                <div style="font-size: 20px;font-weight: bold">商品修改</div>
                <text id="msg" style="color:red">${requestScope.msg}</text>
                <%--                <text style="color: red;margin-top: 10px" id="msg">${requestScope.msg}</text>--%>
                <%--                    <div style="display: flex;flex-direction: row;justify-content:space-around;width:100%">--%>
                <%--                        --%>
                <%--                        <div style="font-size: 15px;color: #0185FE">立即注册</div>--%>
                <%--                    </div>--%>
                <form action="/changeCommodity?type=2" method="post" style="margin-top: 30px;" accept-charset="UTF-8" onsubmit="return checkForm()">
                    <div style="display: flex;flex-direction: column;width:300px;margin-left: 40px">
                        <div class="row">
                            <div style="flex-basis: 25%">商品名称:</div>
                            <input type="text" name="name" id="na" onkeyup="na_hint()" onblur="na_hide()"/>
                            <span id="hint" class="hintclass"></span>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品价格:</div>
                            <input type="text" id="pri" name="price" onkeyup="pri_hint()" onblur="pri_hide()"/>
                            <span id="pri_hint" class="hintclass"></span>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品作者:</div>
                            <input type="text" name="author" id="aut" onkeyup="aut_hint()" onblur="aut_hide()"/>
                            <span id="aut_hint" class="hintclass"></span>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品材质:</div>
                            <input type="text" name="face" id="fac" onkeyup="face_hint()" onblur="face_hide()"/>
                            <span id="face_hint" class="hintclass"></span>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品url:</div>
                            <input type="text" name="url" id="url" onkeyup="url_hint()" onblur="url_hide()"/>
                            <span id="url_hint" class="hintclass"></span>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品库存:</div>
                            <input type="text" name="num" id="num" onkeyup="num_hint()" onblur="num_hide()"/>
                            <span id="num_hint" class="hintclass"></span>
                        </div>
                        <div class="row">
                            <div style="flex-basis: 25%">商品详情:</div>
                            <textarea name="detail" id="det" onkeyup="det_hint()" onblur="det_hide()"></textarea>
                            <span id="det_hint" class="hintclass"></span>
                            <%--                            <input type="text" name="detail"  value="${requestScope.commodity.detail}">--%>
                        </div>
                    </div>
                    <div style="margin-top: 40px;margin-left: 40px">
                        <input type="submit" value="新增"  class="btn" style="margin-left: 30px"/>
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
        width:150px;
    }
    textarea{
        height:80px;
        resize: none;
        width:150px;
    }
    .hintclass{
        margin-left: 10px;
        font-size: 10px;
        color: red;
    }
</style>
</body>
<%--<script src="https://unpkg.com/axios/dist/axios.min.js"></script>--%>
<%--<script src="https://unpkg.com/vue/dist/vue.js"></script>--%>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script>
    $(function (){
        $("#na").click(function (){
            $("#msg").text("")
        })
    })
    function na_hint(){
        let key=$("#na").val();
        let hint=$("#hint");
        console.log(key.length)
        if(key.length==0){
            hint.html("商品名不能为空");
            return false;
        }
        return true;
    }
    function na_hide(){
        let hint=$("#hint");
        hint.html("");
    }
    function pri_hint(){
        let key=$("#pri").val();
        let hint=$("#pri_hint");
        if(key.length==0){
            hint.html("价格不能为空");
            return false;
        }
        else if(isNaN(key)){
            hint.html("价格必须是数字");
            return false;
        }
        return true;
    }
    function pri_hide(){
        let hint=$("#pri_hint");
        hint.html("");
    }
    function aut_hint(){
        let key=$("#aut").val();
        let hint=$("#aut_hint");
        if(key.length==0){
            hint.html("作者不能为空");
            return false;
        }
        return true;
    }
    function aut_hide(){
        let hint=$("#aut_hint");
        hint.html("");
    }
    function face_hint(){
        let key=$("#fac").val();
        let hint=$("#face_hint");
        if(key.length==0){
            hint.html("材质不能为空")
            return false;
        }
        return true;
    }
    function face_hide(){
        let hint=$("#face_hint");
        hint.html("");
    }
    function url_hint(){
        let key=$("#url").val();
        let hint=$("#url_hint");
        if(key.length==0){
            hint.html("url不能为空");
            return false;
        }
        return true;
    }
    function url_hide(){
        let hint=$("#url_hint");
        hint.html("");
    }
    function num_hint(){
        let key=$("#num").val();
        let hint=$("#num_hint");
        if(key.length==0){
            hint.html("库存不能为空");
            return false;
        }
        else if(isNaN(key)){
            hint.html("库存必须为数字")；
            return false;
        }
        return true;
    }
    function num_hide(){
        let hint=$("#num_hint");
        hint.html("");
    }
    function det_hint(){
        let key=$("#det").val();
        let hint=$("#det_hint");
        if(key.length==0){
            hint.html("详情不能为空");
            return false;
        }
        return true;
    }
    function det_hide(){
        let hint=$("#det_hint");
        hint.html("");
    }
    function checkForm(){
        let k=det_hint()&&num_hint()&&url_hint()&&face_hint()&&aut_hint()&&pri_hint()&&na_hint();
        console.log(k)
        return k;
    }
</script>
</html>
