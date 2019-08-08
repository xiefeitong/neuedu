<%--
  Created by IntelliJ IDEA.
  User: 张万杰
  Date: 2019-08-07
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>productupdate</title>
</head>
<body>
<h1>修改商品</h1>

<form action=" " method="post">

    <input type="hidden" name="id" value="${product.id}"><br/>
    <%--类别Id<input type="text" name="categoryId" value="${product.categoryId}">--%>
    类别id<select class="nice-select"  name="categoryId"  value="${product.categoryId}" >
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
    </select>
    <br/>
    商品名称<input type="text" name="name" value="${product.name}"><br/>
    商品副标题<input type="text" name="subtitle" value="${product.subtitle}"><br/>
    商品详情<input type="text" name="detail" value="${product.detail}"><br/>
    价格<input type="text" name="price" value="${product.price}"><br/>
    库存数量<input type="text" name="stock" value="${product.stock}"><br/>
    商品状态<input type="text" name="status" value="${product.status}"><br/>
    <input type="submit"  value="修改"><br/>

</form>
</body>
</html>
