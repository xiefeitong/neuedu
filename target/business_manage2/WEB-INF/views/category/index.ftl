<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="">


                            <input type="hidden" name="id" value="${category.id}"><br/>
                            名称<input type="text" name="name" value="${category.name}"><br/>
                            父类id<input type="text" name="parentId" value="${category.parentId}"><br/>
                            类别状态:<input type="text" name="status" value="${category.status}"><br/>
                            <input type="submit"  value="修改"><br/>


                       <!-- <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>-->
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>