<%--
  Created by IntelliJ IDEA.
  User: 张万杰
  Date: 2019-08-07
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Productlist</title>
</head>
<body>
<a href="/user/product/add" >添加</a>
<table>
    <thead>
    <th>类别Id</th>
    <th>商品名称</th>
    <th>商品副标题</th>
    <th>商品详情</th>
    <th>价格</th>
    <th>库存数量</th>
    <th>商品状态</th>
    <th>操作</th>
    </thead>

    <c:forEach items="${productlist}" var="product">

    <tr>
        <th>${product.categoryId}</th>
        <th>${product.name}</th>
        <th>${product.subtitle}</th>
        <th>${product.detail}</th>
        <th>${product.price}</th>
        <th>${product.stock}</th>
        <th>${product.status}</th>
        <th>
            <a href="update/${product.id}" >修改</a>
            <a href="delete/${product.id}" >删除</a>
        </th>
    </tr>

    </c:forEach>
</body>
</html>
