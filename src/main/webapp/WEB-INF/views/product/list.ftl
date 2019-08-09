<html>
<#include "common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
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
                        </tr>
                        </thead>
                        <tbody>

                        <#list productlist as product>
                        <tr>
                        <tr>
                            <th>${product.categoryId}</th>
                            <th>${product.name}</th>
                            <th>${product.subtitle}</th>
                            <th>${product.detail}</th>
                            <th>${product.price}</th>
                            <th>${product.stock}</th>
                            <th>${product.status}</th>
                            <th>
                                <a href="/user/product/update/${product.id}" >修改</a>
                                <a href="/user/product/delete/${product.id}" >删除</a>
                            </th>
                       <!-- </tr>
                            <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                            <td>
                                <#if productInfo.getProductStatusEnum().message == "在架">
                                    <a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                                <#else>
                                    <a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>
                                </#if>
                            </td>
                        </tr>-->
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..productInfoPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte productInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>