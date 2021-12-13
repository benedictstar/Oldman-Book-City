<%--
  Created by IntelliJ IDEA.
  User: roseh
  Date: 2021/11/11
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>老夫子旧书平台</title>
</head>
<body>
<div>
    <div class="tit">老夫子旧书</div>
    <div style="display: flex;align-items: center;flex-direction: row;justify-content: center;align-items: center;height:550px;background: #0185FE">
        <div style="display: flex;align-items: center;flex-direction: column;flex-basis: 50%;font-size: 40px;color:white">
            欢迎注册
        </div>
        <div style="display: flex;align-items: center;flex-direction: column;flex-basis: 60%">
            <div style="height:450px;width:450px;background: white;display: flex;flex-direction: column;justify-content: center;align-items: center">
                <div style="font-size: 20px;font-weight: bold">注册书城会员</div>
                <text id="msg" style="color:red">${requestScope.msg}</text>

                <form action="/register" method="post" style="margin-top: 30px;" onsubmit="return checkForm()">
                    <div style="display: flex;flex-direction: column;width:300px;margin-left: 40px">
                        <div class="row">
                            <div style="flex-basis: 28%">用户名称:</div>
                            <input autocomplete="off" type="text" name="name"  id="na" onfocus="shopTips('hint','长度不能小于6')" onblur="hint_hide()" onkeyup="hint()"/>
                            <span id="hint"></span>
                        </div>
                        <div class="row" style="margin-top: 20px">
                            <div style="flex-basis: 28%">用户密码:</div>
                            <input autocomplete="off" type="password" name="password" id="word" onfocus="shopTips('pass_hint','用户名长度不能小于6')" onblur="pass_hide()" onkeyup="checkPass()"/>
                            <span id="pass_hint"></span>
                        </div>
                        <div class="row" style="margin-top: 20px">
                            <div style="flex-basis: 28%">确认密码:</div>
                            <input autocomplete="off" type="password" name="password1" id="paword" onfocus="shopTips('passpass_hint','两次的密码要求一致')" onblur="passpass_hide()" onkeyup="checkPassPass()"/>
                            <span id="passpass_hint"></span>
                        </div>
                        <div class="row" style="margin-top: 20px">
                            <div style="flex-basis: 28%">电话号码:</div>
                            <input autocomplete="off" type="text" name="tel" id="tel" onfocus="shopTips('tel_hint','11位数字的手机号')" onblur="phoneHide()" onkeyup="phoneCheck()"/>
                            <span id="tel_hint"></span>
                        </div>
                        <div class="row" style="margin-top: 20px">
                            <div style="flex-basis: 28%">电子邮件:</div>
                            <input autocomplete="off" type="text" name="email" id="email" onfocus="shopTips('email_hint','正确的邮箱格式')" onblur="emailHide()" onkeyup="emailCheck()"/>
                            <span id="email_hint"></span>
                        </div>
                    </div>
                    <div style="margin-top: 40px;display: flex;justify-content: center">
                        <input type="submit" value="注册" class="btn" >
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
    span{
        font-size: 10px;
        color: red;
        width:70px;
        margin-left: 5px;
    }
</style>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function (){
        $("#na").click(function (){
            $("#msg").text("")
        })
        $("#word").click(function (){
            $("#msg").text("")
        })
        $("#tel").click(function (){
            $("#msg").text("")
        })
        $("#email").click(function (){
            $("#msg").text("")
        })
    })
    function shopTips(spanId, tips) {
        var span = document.getElementById(spanId);
        span.innerHTML = tips;
    }
    /**
     * 校验用户名，用户名长度得大于6
     */
    function hint() {
        var value = $("#na").val();
        var hint = $("#hint")
        if(value.length < 6) {
            hint.html("用户名太短");
            return false;
        } else {
            hint.html("用户名合格");
            return true;
        }
    }

    function hint_hide() {
        var hint = $("#hint");
        hint.html("");
    }
    /**
     * 校验密码，密码长度得大于6
     */

    function checkPass() {
        var value = $("#word").val();
        var hint = $("#pass_hint");
        if(value.length < 6) {
            hint.html("密码太短");
            return false;
        } else {
            hint.html("密码格式合格");
            return true;
        }
    }

    function pass_hide() {
        var hint = $("#pass_hint");
        hint.html("");
    }
    /***
     * 确认密码的校验
     */
    function checkPassPass() {
        var papavalue = $("#paword").val();
        var value = $("#word").val();
        var papahint = $("#passpass_hint");
        if(papavalue != value) {
            papahint.html("两次密码不一致");
            return false;
        } else {
            papahint.html("");
            return true;
        }
    }

    function passpass_hide() {
        var papahint = $("#passpass_hint");
        papahint.html("");
    }
    /**
     * 校验邮箱，必须满足下面列出的正则表达式，正确的邮箱输入
     */
    function checkEmail(strEmail)
    {
        var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        if ( emailReg.test(strEmail) ) {
            return true;
        }
        else {
//      alert("您输入的Email地址格式不正确！");
            return false;
        }
    };
    function emailCheck() {
        var emailValue = $("#email").val();
        var email_hint = $("#email_hint");
        var flag = checkEmail(emailValue);
        if(flag) {
            email_hint.html("邮箱格式正确");
            return true;
        } else {
            email_hint.html("邮箱格式错误");
            return false;
        }
    }

    function emailHide() {
        var email_hint = $("#email_hint");
        email_hint.html("");
    }
    /**
     * 校验手机号，必须11位数字
     */
    function checkMobile( strMobile )
    {	//13588888888
        var regu = /^[1][345678][0-9]{9}$/;
        var re = new RegExp(regu);
        if (re.test(strMobile)) {
            return true;
        }
        else {
            return false;
        }
    };
    function phoneCheck() {
        var phone = $("#tel").val();
        var phone_hint = $("#tel_hint");
        var flag = checkMobile(phone);
        if(flag) {
            phone_hint.html("手机号格式正确");
            return true;
        } else {
            phone_hint.html("手机号格式错误");
            return false;
        }
    }

    function phoneHide() {
        var phone_hint = $("#tel_hint");
        phone_hint.html("");
    }
// 整体表单验证，只有所有的输入都符合时才能提交
    function checkForm() {
        var flag = emailCheck() && checkPass() && checkPassPass() && hint() && phoneCheck();
        return flag;
    }
</script>
</html>

