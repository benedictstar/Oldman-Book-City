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
    <title>所有商品展示</title>
</head>
<body>
<div style="margin:50px;display: flex;flex-direction: row;align-items:center;margin-bottom: 25px">
  <h1 style="color: #0185FE;letter-spacing: 5px;margin-left: 50px">老夫子后台管理</h1>
</div>
<div style="display: flex;justify-content: flex-end;margin-right: 90px;margin-bottom: 25px">
  <div class="btn"><a href="addCommodity.jsp" style="color:white;text-decoration: none">+增加商品</a></div>
</div>

<div style="width: 100%;">
  <table style="width: 100%;text-align: center">
    <tr>
      <th>商品名称</th>
      <th>商品材质</th>
      <th>商品价格</th>
      <th>商品作者</th>
      <th>商品图片url</th>
      <th>商品详情</th>
      <th>商品库存</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.totalCommodity.commodities}" var="com">
      <tr style="height:60px">
        <td>${com.commodityname}</td>
        <td>${com.face}</td>
        <td>${com.price}</td>
        <td>${com.author}</td>
        <td>${com.url}</td>
        <td><text  class="spe">${com.detail}</text></td>
        <td>${com.totalnum}</td>
        <td>
          <div>
            <a href="/comdetail?id=${com.com_id}&type=1" style="text-decoration: none;color:#317ef3;">修改</a>
            <a href="/comdetail?id=${com.com_id}&type=2" style="text-decoration: none;color:#317ef3;">删除</a>
          </div>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
<div style="margin-right: 100px;display: flex;justify-content: flex-end;margin-top: 25px;margin-bottom: 50px"><a href="managershow.jsp" style="color: #317ef3">返回首页</a></div>
</body>
<style>
  td{
    width: 30px;
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
  a{
    text-decoration: none;
  }
</style>
</html>
