
<html>
<head>
    <title>Tcategoryadd</title>
</head>
<body>

<h1>添加类别</h1>





<form action="/user/category/add" method="post">

    <input type="hidden" name="id" value="${category.id}"><br/>
    名称<input type="text" name="name" value="${category.name}"><br/>
    父类id<input type="text" name="parentId" value="${category.parentId}"><br/>
    类别状态:<input type="text" name="status" value="${category.status}"><br/>
    <input type="submit"  value="增加"><br/>

</form>



</body>
</html>
